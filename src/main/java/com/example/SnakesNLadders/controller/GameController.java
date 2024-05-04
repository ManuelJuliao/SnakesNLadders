package com.example.SnakesNLadders.controller;

import com.example.SnakesNLadders.model.Move;
import com.example.SnakesNLadders.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private final GameService gameService;
    private Move move;

    private void setMove(Move move){
        this.move = move;

    }

    public GameController(GameService gameService) {
        this.gameService = gameService;

    }

    @PostMapping("/players")
    public ResponseEntity<String> addPlayers(@RequestBody String playerName) {
        gameService.addPlayer(playerName);
        return ResponseEntity.ok("Player added successfully");
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
}