package com.example.SnakesNLadders.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer, String> cells;

    public Board() {
        cells = new HashMap<>();
        //init empty board
        for (int i = 1; i <= 100; i++) {
            cells.put(i, "-"); // Initialize each cell with an empty string
        }
    }

    public void initBoard(){
        addSnakes(cells);
        addLadders(cells);
    }

    private void addLadders(Map<Integer,String> cells) {
        cells.put(2,"L38");
        cells.put(18,"L38");
        cells.put(19,"L38");
        cells.put(22,"L38");
        cells.put(23,"L38");
        cells.put(38,"L38");

        cells.put(7,"L14");
        cells.put(14,"L14");

        cells.put(15,"L26");
        cells.put(26,"L26");

        cells.put(8,"L31");
        cells.put(9,"L31");
        cells.put(12,"L31");
        cells.put(13,"L31");
        cells.put(30,"L31");
        cells.put(31,"L31");
        cells.put(32,"L31");

        cells.put(21,"L42");
        cells.put(39,"L42");
        cells.put(40,"L42");
        cells.put(41,"L42");
        cells.put(42,"L42");

        cells.put(36,"L44");
        cells.put(37,"L44");
        cells.put(44,"L44");
        cells.put(45,"L44");

        cells.put(27,"L84");
        cells.put(28,"L84");
        cells.put(34,"L84");
        cells.put(46,"L84");
        cells.put(47,"L84");
        cells.put(55,"L84");
        cells.put(65,"L84");
        cells.put(66,"L84");
        cells.put(77,"L84");
        cells.put(84,"L84");

        cells.put(51,"L67");
        cells.put(52,"L67");
        cells.put(53,"L67");
        cells.put(67,"L67");
        cells.put(68,"L67");
        cells.put(69,"L67");

        cells.put(87,"L94");
        cells.put(94,"L94");

        cells.put(71,"L91");
        cells.put(90,"L91");
        cells.put(91,"L91");
    }

    private void addSnakes(Map<Integer,String> cells) {
        cells.put(4,"S6");
        cells.put(5,"S6");
        cells.put(6,"S6");
        cells.put(16,"S6");
        cells.put(17,"S6");

        cells.put(11,"S11");
        cells.put(29,"S11");
        cells.put(32,"S11");
        cells.put(33,"S11");
        cells.put(48,"S11");
        cells.put(49,"S11");

        cells.put(24,"S25");
        cells.put(25,"S25");
        cells.put(35,"S25");
        cells.put(37,"S25");
        cells.put(46,"S25");

        cells.put(22,"S19");
        cells.put(38,"S19");
        cells.put(39,"S19");
        cells.put(42,"S19");
        cells.put(43,"S19");
        cells.put(59,"S19");
        cells.put(62,"S19");

        cells.put(58,"S60");
        cells.put(60,"S60");
        cells.put(63,"S60");
        cells.put(64,"S60");

        cells.put(53,"S53");
        cells.put(54,"S53");
        cells.put(55,"S53");
        cells.put(66,"S53");
        cells.put(67,"S53");
        cells.put(74,"S53");
        cells.put(75,"S53");

        cells.put(68,"S68");
        cells.put(72,"S68");
        cells.put(73,"S68");
        cells.put(89,"S68");

        cells.put(88,"S88");
        cells.put(92,"S88");
        cells.put(93,"S88");

        cells.put(85,"S75");
        cells.put(86,"S75");
        cells.put(95,"S75");
        cells.put(96,"S75");

        cells.put(79,"S80");
        cells.put(80,"S80");
        cells.put(81,"S80");
        cells.put(82,"S80");
        cells.put(99,"S80");

    }



    public String getCell(int cellNr) {
        return cells.getOrDefault(cellNr, "-");
    }
}
