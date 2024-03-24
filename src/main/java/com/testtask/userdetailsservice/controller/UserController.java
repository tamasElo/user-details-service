package com.testtask.userdetailsservice.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.testtask.userdetailsservice.controller.dto.request.CreateUserRequest;
import com.testtask.userdetailsservice.controller.dto.response.UserResponse;
import com.testtask.userdetailsservice.controller.mapper.Mapper;
import com.testtask.userdetailsservice.service.UserService;
import com.testtask.userdetailsservice.service.domain.User;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/v1/user-details-service/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final Mapper<CreateUserRequest, User> userMapper;
  private final Mapper<User, UserResponse> userResponseMapper;

  @PostMapping
  public ResponseEntity<UserResponse> createUser(
      @Valid @RequestBody CreateUserRequest createUserRequest) {

    var user = userService.createUser(userMapper.map(createUserRequest));
    return ResponseEntity.status(CREATED)
        .body(userResponseMapper.map(user));
  }
}
