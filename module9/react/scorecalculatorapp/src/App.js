import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Veenila Satya"
        School="Vignan's Institute of Engineering for Women"
        Total={500}
        goal={5}
      />
    </div>
  );
}

export default App;