package com.FSBTech.application.service;

import com.FSBTech.application.dto.GameDto;
import com.FSBTech.application.entity.Game;

import java.util.List;

public interface GameService {

    Game addGame(GameDto game);

    Game getGameByName(String name);

    List<Game> getAllGame();

    Game getUpdateGame(GameDto game, String name);

    String deleteByName(String name);
}
