package com.example.SnakesNLadders.model;

public class Player {

    private String name;
    private int pos; // player position

    public Player(String playername){
        this.name = playername;
        this.pos = 1;
    }

    public String getName(){
        return this.name;
    }

    public int getPos(){
        return pos;
    }

    public void setPos(int position){
        this.pos = position;
    }
}
