import React from 'react';
import logo from './snl-logo.png';
import './App.css';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import AddPlayerPage from './AddPlayerPage';
import GamePage from './GamePage';
import axios from 'axios'; 


function App() {

  const startGame = () => {
    
    axios.post('http://localhost:8080/api/game/start-game')
      .then(response => {
        console.log(response.data); 
        window.location.href = '/game'; 
      })
      .catch(error => {
        console.error('Error starting the game:', error); // Handle error
      });
    }

    const addPlayer = () => {
        window.location.href = '/add-player'
    }
  
  return (
    <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div>
            
            <button className="button start-button" onClick={startGame}>Game</button>
            <button className="button add-player" onClick={addPlayer}>Add Player</button>
            {/* <Link to="/add-player" className="button add-player-page-button">Add Player</Link> */}
          </div>
          
        </header>
      </div>
  );
  
  
}

function Main() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/add-player" element={<AddPlayerPage />} />
        <Route path="/game" element={<GamePage />} />
      </Routes>
    </Router>
  );
}

export default Main;



