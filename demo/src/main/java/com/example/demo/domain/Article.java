package com.example.demo.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
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
@Entity
public class Article extends AuditingFields{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql
	private Long id;

	@Setter
	@Column(nullable = false)
	private String title;

	@Setter
	@Column(nullable = false, length = 10000)
	private String content;

	@Setter
	private String hashtag;

	@ToString.Exclude
	@OrderBy("id")
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private final Set<ArticleComment> articleComments = new LinkedHashSet<>();


	protected Article() {

	}

	private Article(String title, String content, String hashtag) {
		this.title = title;
		this.content = content;
		this.hashtag = hashtag;
	}

	public static Article of(String title, String content, String hashtag) {
		return new Article(title, content, hashtag);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Article article = (Article)o;
		return id != null && Objects.equals(id, article.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
