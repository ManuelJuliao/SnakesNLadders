import React, { useState } from 'react';
import './AddPlayerPage.css'; // Import CSS file for styling
import { Link } from 'react-router-dom'; // Import Link component
import axios from 'axios'; 

function AddPlayerPage() {
  const [players, setPlayers] = useState([]);
  const [newPlayerName, setNewPlayerName] = useState('');
  const [errorMessage, setErrorMessage] = useState('');


  const handleInputChange = (event) => {
    setNewPlayerName(event.target.value);
  };


const handleAddPlayer = () => {
  if (newPlayerName.trim() !== '') {
    if (players.length < 4) {
      setPlayers([...players, newPlayerName]);
      setNewPlayerName('');
      setErrorMessage(''); // Clear error message if player added successfully
    } else {
      setErrorMessage('Maximum number of players (4) reached.');
    }
  } else {
    setErrorMessage('Please enter a valid player name.');
  }
};

const handleSubmit = () => {
    // Make HTTP POST request to backend with list of players
    axios.post('http://localhost:8080/api/game/players', players)
      .then(response => {
        console.log(response.data); // Handle success response
      })
      .catch(error => {
        console.error('Error submitting players:', error); // Handle error
      });
  };

return (
    <div className="add-player-container">
    <h2>Add Player</h2>
    <div className="input-container">
        <input 
        type="text" 
        value={newPlayerName} 
        onChange={handleInputChange} 
        placeholder="Enter player name" 
        className="player-input" />
        <button onClick={handleAddPlayer} className="add-player-button">Add Player</button>
        <button onClick={handleSubmit} type="submit" className="add-player-button">Submit</button>
    </div>
    {errorMessage && <p className="error-message">{errorMessage}</p>} {/* Render error message */}
    <div>
        <h3>Current Players:</h3>
        <ul>
        {players.map((player, index) => (
            <li key={index}>{player}</li>
        ))}
        </ul>
    </div>
    <Link to="/" className="back-button">Back</Link> {/* Add Link for back button */}
    </div>
);



}

export default AddPlayerPage;
