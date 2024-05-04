package com.example.SnakesNLadders.model;

public class Move {
    private Player player;
    private int newPosition;

    private int diceResult;

    public Move(Player player, int newPosition, int diceResult) {
        this.player = player;
        this.newPosition = newPosition;
        this.diceResult = diceResult;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNewPosition() {
        return newPosition;
    }
}
