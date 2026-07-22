import React, { useState } from "react";
import Login from "./Components/Login";
import Guest from "./Components/Guest";
import User from "./Components/User";

function App() {

    const [loggedIn, setLoggedIn] = useState(false);

    function login() {
        setLoggedIn(true);
    }

    function logout() {
        setLoggedIn(false);
    }

    return (

        <div style={{ padding: "20px" }}>

            <h1>Ticket Booking App</h1>

            {

                loggedIn ?

                    <User onLogout={logout} />

                    :

                    <>

                        <Guest />

                        <Login onLogin={login} />

                    </>

            }

        </div>

    );
}

export default App;