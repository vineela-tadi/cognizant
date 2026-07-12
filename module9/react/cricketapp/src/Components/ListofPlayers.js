import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat", score: 98 },
        { name: "Rohit", score: 45 },
        { name: "Gill", score: 80 },
        { name: "Rahul", score: 60 },
        { name: "Hardik", score: 75 },
        { name: "Jadeja", score: 50 },
        { name: "Surya", score: 88 },
        { name: "Pant", score: 65 },
        { name: "Bumrah", score: 35 },
        { name: "Shami", score: 72 },
        { name: "Siraj", score: 55 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            <h3>All Players</h3>

            <ul>
                {
                    players.map((player, index) => (
                        <li key={index}>
                            {player.name} - {player.score}
                        </li>
                    ))
                }
            </ul>

            <h3>Players with Score Below 70</h3>

            <ul>
                {
                    lowScorePlayers.map((player, index) => (
                        <li key={index}>
                            {player.name} - {player.score}
                        </li>
                    ))
                }
            </ul>

        </div>
    );
}

export default ListofPlayers;