package com.example.SnakesNLadders.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer, String> cells;

    public Board() {
        cells = new HashMap<>();
        //init empty board
        for (int i = 1; i <= 100; i++) {
            cells.put(i, ""); // Initialize each cell with an empty string
        }
        addSnakes(cells);
        addLadders();
    }

    private void addLadders() {
    }

    private void addSnakes(Map<Integer,String> cells) {
        cells.put(4,"S6");
        cells.put(5,"S6");
        cells.put(6,"S6");
        cells.put(16,"S6");
        cells.put(17,"S6");

    }

    public String getCell(int cellNr) {
        return cells.getOrDefault(cellNr, "");
    }
}
