import React, { useState } from 'react';
import ConfigurationForm from './components/ConfigurationForm/ConfigurationForm';
import ControlPanel from './components/ControlPanal/ControlPanel';
import LogDisplay from './components/LogDisplay/LogDisplay';
import TicketDisplay from './components/TicketDisplay/TicketDisplay';

const App = () => {
  const [config, setConfig] = useState(null); // Store submitted configuration
  const [isSystemRunning, setIsSystemRunning] = useState(false); // Track system state
  const [logs, setLogs] = useState([]); // Store logs
  const [remainingTickets, setRemainingTickets] = useState(null); // Remaining tickets

  // Handle configuration submission
  const handleConfigSubmit = (newConfig) => {
    setConfig(newConfig);
    setRemainingTickets(newConfig.totalTickets); // Initialize remaining tickets
    addLog('Configuration submitted successfully.');
  };

  // Handle "Start" button click
  const handleStart = () => {
    if (!config) {
      alert('Please submit configuration settings before starting the system.');
      return;
    }
    setIsSystemRunning(true);
    addLog('System started.');
    // Simulate ticket system logic (replace this with API calls)
    simulateTicketProcess();
  };

  // Handle "Stop" button click
  const handleStop = () => {
    setIsSystemRunning(false);
    addLog('System stopped.');
  };

  // Simulate ticket processing (for demonstration purposes)
  const simulateTicketProcess = () => {
    const interval = setInterval(() => {
      setRemainingTickets((prev) => {
        if (prev > 0) {
          const updated = prev - 1; // Decrease tickets
          addLog(`A ticket was purchased. Remaining tickets: ${updated}`);
          return updated;
        } else {
          addLog('All tickets are sold out!');
          clearInterval(interval);
          return 0;
        }
      });
    }, 1000); // Simulate ticket retrieval every second
  };

  // Function to add a new log
  const addLog = (message) => {
    setLogs((prevLogs) => [...prevLogs, message]);
  };

  return (
    <div className="App" style={appStyle}>
      <h1>Ticketing System</h1>
      <ConfigurationForm onSubmit={handleConfigSubmit} />
      <TicketDisplay
        totalTickets={config ? config.totalTickets : null}
        remainingTickets={remainingTickets}
      />
      <ControlPanel onStart={handleStart} onStop={handleStop} />
      <LogDisplay logs={logs} />
      {isSystemRunning && <p style={statusStyle}>System is running...</p>}
    </div>
  );
};

// Styling
const appStyle = {
  fontFamily: 'Arial, sans-serif',
  textAlign: 'center',
  padding: '20px',
};

const statusStyle = {
  color: 'green',
  fontWeight: 'bold',
};

export default App;
