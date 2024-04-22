package kr.co.neo.restfulservice.controller;

import kr.co.neo.restfulservice.domain.Post;
import kr.co.neo.restfulservice.domain.User;
import kr.co.neo.restfulservice.exception.UserNotFoundException;
import kr.co.neo.restfulservice.repository.PostRepository;
import kr.co.neo.restfulservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/jpa")
public class PostJPAController {
    private PostRepository postRepository;
    private UserRepository userRepository;
    @PostMapping("/users/{id}/post")
    public ResponseEntity<User> createPost(@PathVariable int id, @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        User user1 = user.get();
        post.setUser(user1);
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();



        return ResponseEntity.created(location).build();
    }
}
