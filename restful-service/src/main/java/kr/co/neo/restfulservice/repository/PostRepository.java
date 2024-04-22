package kr.co.neo.restfulservice.repository;

import kr.co.neo.restfulservice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
