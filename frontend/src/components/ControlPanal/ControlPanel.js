import React from 'react';
import './ControlPanelStyles.css'; 

const ControlPanel = ({ onStart, onStop, isRunning }) => {
  return (
    <div className="control-panel">
      <button 
        className="button" 
        onClick={onStart} 
        disabled={isRunning}
      >
        Start
      </button>
      <button 
        className="button" 
        onClick={onStop} 
        disabled={isRunning}
      >
        Stop
      </button>
    </div>
  );
};

export default ControlPanel;
