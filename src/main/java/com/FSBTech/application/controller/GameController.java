package com.FSBTech.application.controller;

import com.FSBTech.application.dto.GameDto;
import com.FSBTech.application.entity.CustomeResponseEntity;
import com.FSBTech.application.entity.Game;
import com.FSBTech.application.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;
    @PostMapping("/createGame")
    @CachePut(value="game", key="#gameDto.name")
    public ResponseEntity<Game> createGame(@RequestBody GameDto gameDto){
        log.debug("create Logback {}", gameDto);
        return CustomeResponseEntity.ok(gameService.addGame(gameDto));
    }

    @GetMapping("/getGame/{name}")
    @Cacheable(value="game", key="#name")
    public ResponseEntity<Game> getGameByName(@PathVariable String name)  {
        log.debug("get Logback {}", name);
        return ResponseEntity.ok(gameService.getGameByName(name));
    }

    @GetMapping("/getGames")
    public ResponseEntity<List<Game>> getGames()  {
        log.debug("getGames Logback");
        return ResponseEntity.ok(gameService.getAllGame());
    }

    @PutMapping("/updateGames/{name}")
    @CachePut(value = "game", key = "#gameDto")
    public ResponseEntity<Game> updateGame(@RequestBody GameDto gameDto, @PathVariable String name)  {
        log.debug("update Logback {}", gameDto, name);
        return ResponseEntity.ok(gameService.getUpdateGame(gameDto, name));
    }
    @DeleteMapping("/deleteGame/{name}")
    @CacheEvict(value = "game", allEntries=true)
    public String deleteByName(@PathVariable String name)  {
        log.debug("delete Logback {}", name);
        return gameService.deleteByName(name);
    }
}
