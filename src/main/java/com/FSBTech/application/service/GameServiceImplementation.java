package com.FSBTech.application.service;

import com.FSBTech.application.dto.GameDto;
import com.FSBTech.application.entity.Game;
import com.FSBTech.application.repository.GameServiceRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImplementation implements GameService{

    Logger log = LoggerFactory.getLogger(GameServiceImplementation.class);
    @Autowired
    private GameServiceRepository gameServiceRepository;
    @Override
    public Game addGame(GameDto gameDto) {
        log.debug("GameService create Logback {}", gameDto);
        ModelMapper modelMapper = new ModelMapper();
        Game game = modelMapper.map(gameDto, Game.class);
        log.debug("GameService create game Entity {}", game);
        return gameServiceRepository.save(game);
    }

    @Override
    public Game getGameByName(String name) {
        return gameServiceRepository.getGameById(name);
    }
    @Override
    public List<Game> getAllGame() {
        return gameServiceRepository.findAll();
    }

    @Override
    public Game getUpdateGame(GameDto gameDto, String name) {
        log.debug("GameService update Logback {}", gameDto, name);
        Game game=gameServiceRepository.getGameById(name);
        if(game != null) {
            game.setName(gameDto.getName());
            game.setActive(gameDto.isActive());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            game.setDateOfCreation(timestamp.toString());
        }
        log.debug("GameService updated value {}", game);
        return gameServiceRepository.save(game);
    }

    @Override
    public String deleteByName(String name) {
        log.debug("GameService delete Logback {}", name);
        gameServiceRepository.deleteByName(name);
        return "Deleted Successfully";
    }
}
