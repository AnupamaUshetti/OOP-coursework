import React, { useState } from 'react';
import './ConfigurationStyles.css'; // Import the CSS file

const ConfigurationForm = ({ onSubmit }) => {
  // State for input fields
  const [config, setConfig] = useState({
    totalTickets: '',
    ticketReleaseRate: '',
    customerRetrievalRate: '',
    maxTicketCapacity: '',
  });

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setConfig({ ...config, [name]: value });
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(config); // Pass configuration to the parent component
  };

  return (
    <form onSubmit={handleSubmit} className="configuration-form">
      <h2>Configuration Settings</h2>
      <label>
        Total Tickets Amount:
        <input
          type="number"
          name="totalTickets"
          value={config.totalTickets}
          onChange={handleChange}
          required
        />
      </label>
      <label>
        Ticket Release Rate:
        <input
          type="number"
          name="ticketReleaseRate"
          value={config.ticketReleaseRate}
          onChange={handleChange}
          required
        />
      </label>
      <label>
        Customer Retrieval Rate:
        <input
          type="number"
          name="customerRetrievalRate"
          value={config.customerRetrievalRate}
          onChange={handleChange}
          required
        />
      </label>
      <label>
        Max Ticket Capacity:
        <input
          type="number"
          name="maxTicketCapacity"
          value={config.maxTicketCapacity}
          onChange={handleChange}
          required
        />
      </label>
      <button type="configure">Configure</button>
    </form>
  );
};

export default ConfigurationForm;


