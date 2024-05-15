package kr.co.neo.restfulservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.co.neo.restfulservice.domain.User;
import kr.co.neo.restfulservice.exception.UserNotFoundException;
import kr.co.neo.restfulservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "user-controller",description = "일반 사용자 서비스를 위한 컨트롤러입니다.")
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @Operation(summary = "사용자 정보 조회 API",description = "사용자 ID를 이용해서 사용자 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "OK!!"),
            @ApiResponse(responseCode = "400",description = "BAD REQUEST!!"),
            @ApiResponse(responseCode = "404",description = "USER NOT FOUND"),
            @ApiResponse(responseCode = "500",description = "INTERNAL SERVER ERROR")
    }

    )
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(
            @Parameter(description = "사용자 ID",required = true,example = "1")
            @PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linkTo.withRel("all-users")); //all-users -> http://localhost:8088/users
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User > createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        User deletedUser = userService.deleteById(id);
        if (deletedUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }


        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {
        log.info("messageBody={}", messageBody);
        return "ok";
    }

}
