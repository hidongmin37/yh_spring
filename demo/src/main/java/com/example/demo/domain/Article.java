package com.example.demo.domain;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Table(indexes = {
	@Index(columnList = "title"),
	@Index(columnList = "hashtag"),
	@Index(columnList = "createdAt"),
	@Index(columnList = "createdBy")
})
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql
	private Long id;

	@Setter
	private String title;

	@Setter
	private String content;

	@Setter
	private String hashtag;

	private LocalDateTime createdAt;

	private String createdBy;

	private LocalDateTime modifiedAt;

	private String modifiedBy;


}
