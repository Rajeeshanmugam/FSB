package com.FSBTech.application;

import com.FSBTech.application.entity.Game;
import com.FSBTech.application.repository.GameServiceRepository;
import com.FSBTech.application.service.GameServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class GameServiceTest {

	@MockBean
	GameServiceRepository repository;

	@Autowired
	GameServiceImplementation service;
	@Test
	void addGame() {
		// given
		final var gameToSave = Game.builder().gameId(123L).name("Mary").dateOfCreation("2020-10-10").active(true).build();
		when(repository.save(any(Game.class))).thenReturn(gameToSave);
		Game gameResult = repository.save(gameToSave);
		// Assert
		assertThat(gameResult).usingRecursiveComparison().isEqualTo(gameToSave);
	}

}
