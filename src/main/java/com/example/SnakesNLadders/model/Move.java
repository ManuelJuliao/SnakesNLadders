package com.example.SnakesNLadders.model;

public class Move {
    private Player player;
    private int newPosition;

    private int diceResult;

    private boolean victory;

    public Move(Player player, int newPosition, int diceResult, boolean victory) {
        this.player = player;
        this.newPosition = newPosition;
        this.diceResult = diceResult;
        this.victory = victory;
    }

    public Player getPlayer() {
        return player;
    }

    public int getDice() {
        return diceResult;
    }

    public int getNewPosition() {
        return newPosition;
    }

    public boolean getVictory(){
        return victory;
    }

}
