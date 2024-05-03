package com.example.SnakesNLadders.service;

import com.example.SnakesNLadders.model.Board;
import com.example.SnakesNLadders.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private Board board;
    private List<Player> players;

    public GameService() {
        this.board = new Board();
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        // Logic to start the game
    }

    // Other game-related methods (movePlayer, checkForSnakesAndLadders, etc.)
}