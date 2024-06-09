package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@DisplayName("view controller")
@WebMvcTest
class ArticleControllerTest {

	private final MockMvc mockMvc;

	public ArticleControllerTest(@Autowired MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
	public void given_and_then_All() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/articles"))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
			.andExpect(model().attributeExists("articles"));
	}
	@Test
	public void given_and_then_one() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/articles/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_HTML))
			.andExpect(model().attributeExists("articles"))
			.andExpect(model().attributeExists("articleComment"));
	}
	@Test
	public void given_and_then_search() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/articles/search"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_HTML));
	}

	@Test
	public void given_and_then_searchTags() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/articles/search-hashtag"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_HTML));
	}
}