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
        printBoard();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        // Logic to start the game
    }

    public void printBoard() {
        for (int i = 1; i <= 100; i++) {
            String cellContent = board.getCell(i);
            System.out.print(cellContent);

            if(i%10==0)
                System.out.println();

        }
    }

    // Other game-related methods (movePlayer, checkForSnakesAndLadders, etc.)
}