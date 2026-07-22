import React from "react";

function User(props) {

    return (

        <div>

            <h2>Welcome User</h2>

            <h3>Flight Details</h3>

            <ul>
                <li>Flight : Air India</li>
                <li>From : Hyderabad</li>
                <li>To : Delhi</li>
                <li>Time : 10:30 AM</li>
            </ul>

            <button>
                Book Ticket
            </button>

            <br /><br />

            <button onClick={props.onLogout}>
                Logout
            </button>

        </div>

    );
}

export default User;