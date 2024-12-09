import React from 'react';
import './TicketDisplayStyles.css'; // Import the CSS file

const TicketDisplay = ({ totalTickets, remainingTickets }) => {
  return (
    <div className="ticket-display">
      <h2>Ticket Status</h2>
      <p className="ticket-info">
        <strong>Total Tickets:</strong> {totalTickets !== null ? totalTickets : 'Not Configured'}
      </p>
      <p className="ticket-info">
        <strong>Remaining Tickets:</strong> {remainingTickets !== null ? remainingTickets : 'Not Available'}
      </p>
    </div>
  );
};

export default TicketDisplay;


