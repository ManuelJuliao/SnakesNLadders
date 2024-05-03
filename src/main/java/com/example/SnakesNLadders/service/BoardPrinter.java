package com.example.SnakesNLadders.service;

import com.example.SnakesNLadders.model.Board;

public class BoardPrinter {
    private final Board board;

    public BoardPrinter(Board board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 1; i <= 100; i++) {
            String cellContent = board.getCell(i);
            System.out.print(cellContent);
            if(i%10==0)
                System.out.println();

        }
    }
}
