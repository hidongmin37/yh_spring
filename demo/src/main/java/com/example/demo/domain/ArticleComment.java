package com.example.demo.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Table(indexes = {
	@Index(columnList = "content"),
	@Index(columnList = "createdAt"),
	@Index(columnList = "createdBy")
})
@Entity
public class ArticleComment extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql
	private Long id;

	@Setter
	@ManyToOne(optional = false)
	private Article article;

	@Setter
	@Column(nullable = false,length = 500)
	private String content;




	protected ArticleComment() {

	}

	public ArticleComment(Article article, String content) {
		this.article = article;
		this.content = content;
	}

	public static ArticleComment of(Article article, String content) {
		return new ArticleComment(article, content);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ArticleComment that = (ArticleComment)o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
