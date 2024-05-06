package com.example.SnakesNLadders.service;

import com.example.SnakesNLadders.model.Board;
import com.example.SnakesNLadders.model.Move;
import com.example.SnakesNLadders.model.Player;
import org.springframework.stereotype.Service;

import java.util.*;

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
        System.out.println(players);
    }

    public void addPlayers(List<String> playerNames) {
        for (String playerName : playerNames) {
            Player player = new Player(playerName);
            players.add(player);
        }
        System.out.println(players);
    }
    public void startGame() {
        board.initBoard();
        System.out.println("Board init");
    }

    public Map<String, Integer> getPlayerNamesAndPositions() {
        Map<String, Integer> playerNamesAndPositions = new HashMap<>();
        for (Player player : players) {
            playerNamesAndPositions.put(player.getName(), player.getPos());
        }
        return playerNamesAndPositions;
    }


    public void printBoard() {
        for (int i = 1; i <= 100; i++) {
            String cellContent = board.getCell(i);
            System.out.print(cellContent);

            if(i%10==0)
                System.out.println();

        }
    }

    public Move movePlayer(){
        Player currentPlayer = players.get(currentPlayerIndex);
        int currentPos = currentPlayer.getPos();
        int newPos;
        int totalDice;
        if(doubleFlag)
            doubleFlag = false;

        int[] rolls = rollTwoDice();
        if (rolls[0]==rolls[1]){
            doubleFlag = true;
        }
        totalDice = rolls[0]+rolls[1];
        //newPos = currentPos+totalDice;

        if( currentPos+totalDice > 100){
            int diff = (currentPos+totalDice) - 100;
            newPos = 100 - diff;
        }
        else{
            newPos = currentPos+totalDice;
        }

        currentPlayer.setPos(newPos);
        currentPlayer.setPos(checkForSnakesOrLadders(currentPlayer,board));


        checkVictory(currentPlayer);
        if(!doubleFlag)
            nextPlayer();

        Player newPlayer = players.get(currentPlayerIndex);

        Move move = new Move(newPlayer,newPos,totalDice,victory);
        System.out.println(move);

        return move;
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