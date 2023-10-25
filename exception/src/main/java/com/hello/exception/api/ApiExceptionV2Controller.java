package com.hello.exception.api;

import com.hello.exception.exception.UserException;
import com.hello.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApiExceptionV2Controller {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e){
        log.info("[exceptionHandler] ex",e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler//UserException로 똑같은 경우 생략이 가능
    public ResponseEntity<ErrorResult> userExHandler(UserException e) {
        log.error("[exceptionHandler] ex", e);
        ErrorResult errorResult = new ErrorResult("USER-EX3", e.getMessage());
    return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler//이 컨트롤러안에서만 적용이 되고, 다른 컨트롤러와는 상관이 없음
    public ErrorResult exHandler(Exception e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }

    @GetMapping("/api2/members/{id}")
    public MemberDTO getMember(@PathVariable("id") String id) {



        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }

        if (id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력 값");
        }

        if (id.equals("user-ex")) {
            throw new UserException("사용자 오류");
        }

        return new MemberDTO(id, "hello" + id);
    }


    @Data
    @AllArgsConstructor
    static class MemberDTO {
        private String memberId;
        private String name;
    }
}
