import React, { useState } from 'react';

const ConfigurationForm = ({ onSubmit }) => {
  const [formData, setFormData] = useState({
    totalTickets: '',
    ticketReleaseRate: '',
    customerRetrievalRate: '',
    maxTicketCapacity: '',
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    onSubmit(formData);
  };

  return (
    <form onSubmit={handleSubmit} style={formStyle}>
      <h2 style={headerStyle}>Configuration Settings</h2>

      <div style={inputGroupStyle}>
        <label htmlFor="totalTickets" style={labelStyle}>Total Tickets:</label>
        <input
          type="number"
          id="totalTickets"
          name="totalTickets"
          value={formData.totalTickets}
          onChange={handleChange}
          style={inputStyle}
        />
      </div>

      <div style={inputGroupStyle}>
        <label htmlFor="ticketReleaseRate" style={labelStyle}>Ticket Release Rate:</label>
        <input
          type="number"
          id="ticketReleaseRate"
          name="ticketReleaseRate"
          value={formData.ticketReleaseRate}
          onChange={handleChange}
          style={inputStyle}
        />
      </div>

      <div style={inputGroupStyle}>
        <label htmlFor="customerRetrievalRate" style={labelStyle}>Customer Retrieval Rate:</label>
        <input
          type="number"
          id="customerRetrievalRate"
          name="customerRetrievalRate"
          value={formData.customerRetrievalRate}
          onChange={handleChange}
          style={inputStyle}
        />
      </div>

      <div style={inputGroupStyle}>
        <label htmlFor="maxTicketCapacity" style={labelStyle}>Max Ticket Capacity:</label>
        <input
          type="number"
          id="maxTicketCapacity"
          name="maxTicketCapacity"
          value={formData.maxTicketCapacity}
          onChange={handleChange}
          style={inputStyle}
        />
      </div>

      <button type="submit" style={buttonStyle}>Submit</button>
    </form>
  );
};

// Styling
const formStyle = {
  margin: '0 auto',
  padding: '20px',
  maxWidth: '400px',
  border: '1px solid #ccc',
  borderRadius: '8px',
  backgroundColor: '#f9f9f9',
  textAlign: 'center',
};

const headerStyle = {
  marginBottom: '20px',
};

const inputGroupStyle = {
  marginBottom: '15px',
  textAlign: 'left',
};

const labelStyle = {
  display: 'block', // Ensures the label is on top of the input field
  marginBottom: '5px',
};

const inputStyle = {
  width: '100%',
  padding: '8px',
  fontSize: '14px',
  border: '1px solid #ccc',
  borderRadius: '4px',
};

const buttonStyle = {
  backgroundColor: '#007bff',
  color: '#fff',
  border: 'none',
  borderRadius: '4px',
  padding: '10px 20px',
  fontSize: '16px',
  cursor: 'pointer',
};

export default ConfigurationForm;

