import React, { useState } from "react";

function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Ticket Booking App</h1>

      {loggedIn ? (
        <div>
          <h2>Welcome User</h2>

          <h3>Flight Details</h3>

          <p>Flight: Air India</p>
          <p>From: Hyderabad</p>
          <p>To: Delhi</p>

          <button>Book Ticket</button>

          <br /><br />

          <button onClick={() => setLoggedIn(false)}>
            Logout
          </button>
        </div>
      ) : (
        <div>
          <h2>Welcome Guest</h2>

          <h3>Flight Details</h3>

          <p>Flight: Air India</p>
          <p>From: Hyderabad</p>
          <p>To: Delhi</p>

          <p>Please Login to Book Tickets.</p>

          <button onClick={() => setLoggedIn(true)}>
            Login
          </button>
        </div>
      )}
    </div>
  );
}

export default App;