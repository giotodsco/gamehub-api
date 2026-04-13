package com.todesco.gamehub.controller;

import com.todesco.gamehub.dtos.request.CategoryRequest;
import com.todesco.gamehub.dtos.request.GameStoreRequest;
import com.todesco.gamehub.dtos.response.CategoryResponse;
import com.todesco.gamehub.dtos.response.GameStoreResponse;
import com.todesco.gamehub.service.GameStoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamehub/gamestore")
@RequiredArgsConstructor
public class GameStoreController {

    private final GameStoreService gameStoreService;

    @GetMapping("/find/all")
    public ResponseEntity<List<GameStoreResponse>> listAllGameStore(){
        return ResponseEntity.status(HttpStatus.OK).body(gameStoreService.listAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GameStoreResponse> listPerId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(gameStoreService.listPerId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<GameStoreResponse> createGameStore(@Valid @RequestBody GameStoreRequest gameStoreRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameStoreService.createGameStore(gameStoreRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        gameStoreService.deletePerId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
