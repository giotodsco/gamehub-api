package com.todesco.gamehub.controller;

import com.todesco.gamehub.dtos.request.GameRequest;
import com.todesco.gamehub.dtos.response.GameResponse;
import com.todesco.gamehub.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamehub/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/create")
    public ResponseEntity<GameResponse> createGame(@RequestBody GameRequest gameRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.createGame(gameRequest));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GameResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findById(id));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<GameResponse>> findyAll(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.listAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        gameService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GameResponse> update(@PathVariable Long id, @RequestBody GameRequest gameRequest){
        return ResponseEntity.ok(gameService.updateGame(id, gameRequest));
    }

}
