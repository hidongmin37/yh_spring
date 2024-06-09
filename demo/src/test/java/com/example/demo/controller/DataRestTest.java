package com.example.demo.controller;


import static org.springframework.http.ResponseEntity.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import jakarta.transaction.Transactional;

@Disabled("spring Data rest 통합테스트는 불필요하므로 제외시킴")
@AutoConfigureMockMvc
@WebMvcTest
public class DataRestTest {

	@MockBean
	private final MockMvc mockMvc;

	public DataRestTest(@Autowired MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
	@Transactional
	void articleReturn() throws Exception {

		mockMvc.perform(get("/api/articles"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
	}


}
