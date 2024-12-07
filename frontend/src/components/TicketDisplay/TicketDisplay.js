import React from 'react';

const TicketDisplay = ({ totalTickets, remainingTickets }) => {
  return (
    <div style={containerStyle}>
      <h2>Ticket Status</h2>
      <p style={ticketInfoStyle}>
        <strong>Total Tickets:</strong> {totalTickets !== null ? totalTickets : 'Not Configured'}
      </p>
      <p style={ticketInfoStyle}>
        <strong>Remaining Tickets:</strong> {remainingTickets !== null ? remainingTickets : 'Not Available'}
      </p>
    </div>
  );
};

// Inline styles
const containerStyle = {
  margin: '20px auto',
  padding: '20px',
  width: '300px',
  border: '1px solid #ccc',
  borderRadius: '8px',
  backgroundColor: '#f9f9f9',
  textAlign: 'center',
};

const ticketInfoStyle = {
  margin: '10px 0',
  fontSize: '16px',
};

export default TicketDisplay;

