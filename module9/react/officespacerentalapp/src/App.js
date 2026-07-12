import React from "react";
import officeImage from "./Images/office.jpg";

function App() {

  const office = {
    name: "Smart Business Center",
    rent: 55000,
    address: "Hyderabad"
  };

  const offices = [
    {
      name: "Smart Business Center",
      rent: 55000,
      address: "Hyderabad"
    },
    {
      name: "Tech Park",
      rent: 75000,
      address: "Bangalore"
    },
    {
      name: "Cyber Towers",
      rent: 45000,
      address: "Chennai"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office"
        width="400"
      />

      <h2>Single Office Details</h2>

      <p><b>Name:</b> {office.name}</p>

      <p>
        <b>Rent:</b>

        <span style={{
          color: office.rent < 60000 ? "red" : "green"
        }}>
          ₹{office.rent}
        </span>

      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>Office List</h2>

      {
        offices.map((item,index)=>(
          <div key={index}>

            <p><b>Name:</b> {item.name}</p>

            <p>
              <b>Rent:</b>

              <span style={{
                color:item.rent<60000?"red":"green"
              }}>
                ₹{item.rent}
              </span>

            </p>

            <p><b>Address:</b> {item.address}</p>

            <hr/>

          </div>
        ))
      }

    </div>
  );
}

export default App;