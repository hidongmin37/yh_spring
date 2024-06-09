package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;

import com.example.demo.config.JpaConfig;
import com.example.demo.repository.ArticleCommentRepository;
import com.example.demo.repository.ArticleRepository;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJdbcTest
class JpaRepositoryTest {



	private final ArticleRepository articleRepository;

	private final ArticleCommentRepository articleCommentRepository;

	public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,@Autowired ArticleCommentRepository articleCommentRepository) {
		this.articleRepository = articleRepository;
		this.articleCommentRepository = articleCommentRepository;
	}


}