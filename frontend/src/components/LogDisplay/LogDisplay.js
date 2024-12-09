import React from 'react';
import './LogDisplayStyles.css'; // Import the CSS file

const LogDisplay = ({ logs }) => {
  return (
    <div className="log-container">
      <h2>Logs</h2>
      <div className="log-list">
        {logs.length > 0 ? (
          logs.map((log, index) => (
            <p key={index} className="log-item">
              {log}
            </p>
          ))
        ) : (
          <p className="empty-log">No logs to display.</p>
        )}
      </div>
    </div>
  );
};

export default LogDisplay;

