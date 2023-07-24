package com.FSBTech.application;

import com.FSBTech.application.dto.GameDto;
import com.FSBTech.application.entity.Game;
import com.FSBTech.application.repository.GameServiceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private GameServiceRepository repository;

	@Test
	void addGame() throws Exception{
		// Act
		final var gameToAdd = Game.builder().name("Mary").active(true).build();
		mockMvc.perform(post("/create")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(gameToAdd)));
				//.andExpect(status().isOk());
		Game userEntity = repository.getGameById("Mary");
		//assertThat(userEntity.getName()).isEqualTo("Mary");
	}

}
