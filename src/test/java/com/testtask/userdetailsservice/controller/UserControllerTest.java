package com.testtask.userdetailsservice.controller;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.http.HttpStatus.CREATED;

import com.testtask.userdetailsservice.controller.dto.request.CreateUserRequest;
import com.testtask.userdetailsservice.controller.dto.response.UserResponse;
import com.testtask.userdetailsservice.controller.mapper.Mapper;
import com.testtask.userdetailsservice.service.UserService;
import com.testtask.userdetailsservice.service.domain.User;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

  @Mock
  private UserService mockUserService;

  @Mock
  private Mapper<CreateUserRequest, User> mockUserMapper;

  @Mock
  private Mapper<User, UserResponse> mockUserResponseMapper;

  private UserController underTest;

  @BeforeEach
  void setUp() {
    underTest = new UserController(
        mockUserService,
        mockUserMapper,
        mockUserResponseMapper
    );
  }

  @Test
  void createUserShouldReturnCreatedUserDetails() {
    // GIVEN
    var createUserRequest = CreateUserRequest.builder().build();
    var user = User.builder().build();
    var userResponse = UserResponse.builder().build();
    var expected = ResponseEntity.status(CREATED).body(userResponse);

    given(mockUserMapper.map(createUserRequest))
        .willReturn(user);
    given(mockUserService.createUser(user))
        .willReturn(user);
    given(mockUserResponseMapper.map(user))
        .willReturn(userResponse);

    // WHEN
    var result = underTest.createUser(createUserRequest);

    // THEN
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void getUsersShouldReturnAllUsers() {
    // GIVEN
    var user = User.builder().build();
    var userResponse = UserResponse.builder().build();
    var expected = ResponseEntity.ok(singletonList(userResponse));

    given(mockUserService.getUsers())
        .willReturn(singletonList(user));
    given(mockUserResponseMapper.map(user))
        .willReturn(userResponse);

    // WHEN
    var result = underTest.getUsers();

    // THEN
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void depersonalizeUserShouldReturnUuidOfDepersonalizedUser() {
    // GIVEN
    var uuid = UUID.randomUUID();
    var expected = ResponseEntity.ok(uuid);

    // WHEN
    var result = underTest.depersonalizeUser(uuid);

    // THEN
    assertThat(result).isEqualTo(expected);

    then(mockUserService).should()
        .depersonalizeUser(uuid);
  }
}
