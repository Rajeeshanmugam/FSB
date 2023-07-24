package com.FSBTech.application;

import com.FSBTech.application.dto.GameDto;
import com.FSBTech.application.entity.Game;
import com.FSBTech.application.repository.GameServiceRepository;
import com.FSBTech.application.service.GameServiceImplementation;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

class GameServiceTest {

	@Mock
	GameServiceRepository repository;

	@InjectMocks
	GameServiceImplementation service;
	@Test
	void addGame() {
		// Arrange
		final var gameToSave = Game.builder().name("Mary").active(true).build();
		when(repository.save(any(Game.class))).thenReturn(gameToSave);

		// Act
		final var gameToAdd = GameDto.builder().name("Mary").active(true).build();
		final var actual = service.addGame(gameToAdd);

		// Assert
		assertThat(actual).usingRecursiveComparison().isEqualTo(gameToSave);
		verify(repository, times(1)).save(any(Game.class));
		verifyNoMoreInteractions(repository);
	}


}
