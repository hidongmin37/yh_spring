package kr.co.neo.restfulservice.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import kr.co.neo.restfulservice.domain.Post;
import kr.co.neo.restfulservice.domain.User;
import kr.co.neo.restfulservice.exception.UserNotFoundException;
import kr.co.neo.restfulservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
@RequestMapping("/jpa")
public class UserJPAController {

    private UserRepository userRepository;

    @GetMapping("/users")
    public Map<String, Object> retrieveAllUsers() {
        List<User> users = userRepository.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("count", users.size());
        response.put("users", users);
        return response;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity retrieveUser(
            @Parameter(description = "사용자 ID", required = true, example = "1")
            @PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linkTo.withRel("all-users")); //all-users -> http://localhost:8088/users
        return ResponseEntity.ok(entityModel);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostsByUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user.get().getPost();

    }



}
