import React from 'react';

const ControlPanel = ({ onStart, onStop }) => {
  return (
    <div style={panelStyle}>
      <h2>Control Panel</h2>
      <button onClick={onStart} style={buttonStyle}>
        Start
      </button>
      <button onClick={onStop} style={buttonStyle}>
        Stop
      </button>
    </div>
  );
};

// Inline styles
const panelStyle = {
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  gap: '10px',
  margin: '20px auto',
  padding: '20px',
  width: '200px',
  border: '1px solid #ccc',
  borderRadius: '8px',
  backgroundColor: '#f1f1f1',
};

const buttonStyle = {
  padding: '10px 20px',
  backgroundColor: '#28a745',
  color: '#fff',
  border: 'none',
  borderRadius: '4px',
  cursor: 'pointer',
};

export default ControlPanel;
