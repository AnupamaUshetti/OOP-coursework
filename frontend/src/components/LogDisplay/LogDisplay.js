import React from 'react';

const LogDisplay = ({ logs }) => {
  return (
    <div style={logContainerStyle}>
      <h2>Logs</h2>
      <div style={logListStyle}>
        {logs.length > 0 ? (
          logs.map((log, index) => (
            <p key={index} style={logItemStyle}>
              {log}
            </p>
          ))
        ) : (
          <p style={emptyLogStyle}>No logs to display.</p>
        )}
      </div>
    </div>
  );
};

// Inline styles
const logContainerStyle = {
  margin: '20px auto',
  padding: '20px',
  width: '400px',
  border: '1px solid #ccc',
  borderRadius: '8px',
  backgroundColor: '#f9f9f9',
};

const logListStyle = {
  maxHeight: '200px',
  overflowY: 'auto',
};

const logItemStyle = {
  margin: '5px 0',
  padding: '5px',
  backgroundColor: '#e1f5fe',
  borderRadius: '4px',
};

const emptyLogStyle = {
  color: '#777',
  fontStyle: 'italic',
};

export default LogDisplay;
