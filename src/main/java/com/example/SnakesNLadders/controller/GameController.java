package com.example.SnakesNLadders.controller;

import com.example.SnakesNLadders.model.Player;
import com.example.SnakesNLadders.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/players")
    public ResponseEntity<String> addPlayers(@RequestBody List<String> playerNames) {
        for (String playerName : playerNames) {
            gameService.addPlayer(new Player(playerName));
        }
        return ResponseEntity.ok("Player added successfully");
    }
}