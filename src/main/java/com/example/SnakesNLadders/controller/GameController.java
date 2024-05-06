package com.example.SnakesNLadders.controller;

import com.example.SnakesNLadders.model.Move;
import com.example.SnakesNLadders.model.Player;
import com.example.SnakesNLadders.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/game")
public class GameController { //class responsible for the
    @Autowired
    private final GameService gameService;
    private Move move;

    private void setMove(Move move){
        this.move = move;

    }

    public GameController(GameService gameService) {
        this.gameService = gameService;

    }

    @PostMapping("/player")
    public ResponseEntity<String> addPlayer(@RequestBody String playerName) {
        gameService.addPlayer(playerName);
        return ResponseEntity.ok("Player added successfully");
    }

    @PostMapping("/players")
    public ResponseEntity<String> addPlayers(@RequestBody List<String> playerNames) {
        gameService.addPlayers(playerNames);
        return ResponseEntity.ok("Players added successfully");
    }




    @PostMapping("/start-game")
    public ResponseEntity<?> startGame() {
        gameService.startGame();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/move")
    public ResponseEntity<?> movePlayer() {
        setMove(gameService.movePlayer());
        return ResponseEntity.ok(move);
    }

    @GetMapping("get-players")
    public ResponseEntity<Map<String,Integer>> getPlayers() {
        Map<String,Integer> players = gameService.getPlayerNamesAndPositions();
        return ResponseEntity.ok(players);
    }
}