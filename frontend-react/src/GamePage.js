import React, { useState, useEffect } from 'react';
import background from './background.png';
import './GamePage.css';
import axios from 'axios'; 


function GamePage() {
  // State to store grid data as a flat list
  const [gridData, setGridData] = useState([]);
  const [players, setPlayers] = useState([]);
  const [currentPlayer, setCurrentPlayer] = useState('');

const generateGridData = () => {
    const data = [];
    let cellNumber = 100;
    for (let i = 0; i < 10; i++) {
      const row = [];
      for (let j = 0; j < 10; j++) {
        if (i % 2 === 0) {
          row.push(cellNumber);
        } else {
          row.unshift(cellNumber);
        }
        cellNumber--;
      }
      data.push(...row);
    }
    return data;
  };
  
  

  
  useEffect(() => {
    axios.get('http://localhost:8080/api/game/get-players')
    .then(response => {
        
        const playersData = response.data;

        // Convert map to array of player objects [{ name: ..., position: ... }]
        const playersArray = Object.entries(playersData).map(([name, position]) => ({
            name,
            position
        }));

        setPlayers(playersArray);

        if (playersArray.length > 0) {
            setCurrentPlayer(playersArray[0].name);
        }
    })
    .catch(error => {
        console.error('Failed to fetch player data:', error);
    });
    setGridData(generateGridData());
}, []);

  // Function to access a specific cell in the grid data
  const accessCell = (index) => {
    if (index >= 0 && index < gridData.length) {
      return gridData[index];
    }
    return null;
  };

  const rollDice = () => {
    
  };

  return (
    <div className="game-page">
      <div className="title-container">
        <h2>Snakes 'n Ladders</h2>
      </div>
      <div className="container-wrapper">
        <div className="board-container">
          <div className="board">
            <div className="grid">
              {gridData.map((cell, index) => (
                <div className="cell">
                    <span className="hidden">{cell}</span>            
                </div>
              ))}
            </div>
            <img src={background} className="background-image" alt="background" />
          </div>
        </div>
        <div className="empty-container">
            <button onClick={rollDice}>Roll Dice</button>
            <div>Current Player: {currentPlayer}</div>
            <ul className="player-list">
            {players.map((player, index) => (
            <li key={index} className="player-item">
            <div className="player-number">Player {index + 1}</div>
            <div className="player-info">
                <div className="player-name">{player.name}</div>
                <div className="player-position">Position: {player.position}</div>
            </div>
        </li>
    ))}
</ul>
     </div>
</div>

      </div>
   
  );
}

export default GamePage;
