import React from 'react';
import logo from './snl-logo.png';
import './App.css';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import AddPlayerPage from './AddPlayerPage';

function App() {
  
  return (
    <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div>
            
            <button className="button start-button" onClick={startGame}>Start Game</button>
            <Link to="/add-player" className="button add-player-page-button">Add Player</Link>
          </div>
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
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
      </Routes>
    </Router>
  );
}

export default Main;

function startGame() {
  // Logic for starting the game
}

function addPlayer() {
  // Logic for adding a player
}



