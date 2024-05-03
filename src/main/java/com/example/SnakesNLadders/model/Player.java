package com.example.SnakesNLadders.model;

public class Player {

    private String name;
    private int pos; // player position

    public Player(String playername){
        this.name = playername;
        this.pos = 0;
    }

    String getName(){
        return this.name;
    }

    int getPos(){
        return pos;
    }

    void setPos(int position){
        this.pos = position;
    }
}
