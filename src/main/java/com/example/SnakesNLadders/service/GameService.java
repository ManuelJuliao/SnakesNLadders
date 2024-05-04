package com.example.SnakesNLadders.service;

import com.example.SnakesNLadders.model.Board;
import com.example.SnakesNLadders.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class GameService {
    private Board board;
    private List<Player> players;

    private boolean doubleFlag;
    private boolean victory;
    private int currentPlayerIndex;

    public GameService() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.doubleFlag = false;
        this.victory = false;
        this.currentPlayerIndex = 0;
        printBoard();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public String getCurrentPlayerName() {
        return getCurrentPlayer().getName();
    }

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }
    public void startGame() {
        board.initBoard();

    }

    public void printBoard() {
        for (int i = 1; i <= 100; i++) {
            String cellContent = board.getCell(i);
            System.out.print(cellContent);

            if(i%10==0)
                System.out.println();

        }
    }

    void movePlayer(Player player){
        int currentPos = player.getPos();
        int newPos;
        if(doubleFlag)
            doubleFlag = false;

        int[] rolls = rollTwoDice();
        if (rolls[0]==rolls[1]){
            doubleFlag = true;
        }
        newPos = currentPos+rolls[0]+rolls[1];
        player.setPos(newPos);
        player.setPos(checkForSnakesOrLadders(player,board));


        checkVictory(player);
        nextPlayer();

    }

    private void checkVictory(Player player) {
        if(player.getPos()==100)
            victory =true;
    }

    private void check100() {
    }

    int checkForSnakesOrLadders(Player player, Board board){
        String cell = board.getCell(player.getPos());
        if(cell.equals("-"))
            return player.getPos();
        else {
            return Integer.parseInt(cell.substring(1));
        }
    }

    public static int[] rollTwoDice() {
        Random rand = new Random();
        int[] rolls = { rand.nextInt(6) + 1, rand.nextInt(6) + 1 }; // Roll two dice
        return rolls;
    }
}