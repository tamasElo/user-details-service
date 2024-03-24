package com.testtask.userdetailsservice.service;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import com.testtask.userdetailsservice.repository.AddressRepository;
import com.testtask.userdetailsservice.repository.UserRepository;
import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.repository.entity.UserEntity;
import com.testtask.userdetailsservice.service.domain.User;
import com.testtask.userdetailsservice.service.mapper.Mapper;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultUserServiceTest {

  @Mock
  private UserRepository mockUserRepository;

  @Mock
  private AddressRepository mockAddressRepository;

  @Mock
  private Mapper<User, UserEntity> mockUserEntityMapper;

  @Mock
  private Mapper<UserEntity, User> mockUserMapper;

  private DefaultUserService underTest;

  @BeforeEach
  void setUp() {
    underTest = new DefaultUserService(
        mockUserRepository,
        mockAddressRepository,
        mockUserEntityMapper,
        mockUserMapper
    );
  }

  @Test
  void createUserShouldReturnCreatedUser() {
    // GIVEN
    var user = User.builder().build();
    var userEntity = UserEntity.builder().build();

    given(mockUserEntityMapper.map(user))
        .willReturn(userEntity);
    given(mockUserRepository.save(userEntity))
        .willReturn(userEntity);
    given(mockUserMapper.map(userEntity))
        .willReturn(user);

    // WHEN
    var result = underTest.createUser(user);

    // THEN
    assertThat(result).isEqualTo(user);
  }

  @Test
  void getUsersShouldReturnUsers() {
    // GIVEN
    var userEntity = UserEntity.builder().build();
    var userEntities = singletonList(userEntity);
    var user = User.builder().build();

    given(mockUserRepository.findAll())
        .willReturn(userEntities);
    given(mockUserMapper.map(userEntity))
        .willReturn(user);

    // WHEN
    var result = underTest.getUsers();

    // THEN
    assertThat(result).isEqualTo(singletonList(user));
  }

  @Test
  void depersonalizeUserShouldCallMethodsOnRepositories() {
    // GIVEN
    var userUuid = UUID.randomUUID();
    var addressUuid = UUID.randomUUID();

    var addressEntity = AddressEntity.builder()
        .uuid(addressUuid)
        .build();

    var addressEntities = singletonList(addressEntity);

    given(mockAddressRepository.findByUserUuid(userUuid))
        .willReturn(addressEntities);

    // WHEN
    underTest.depersonalizeUser(userUuid);

    // THEN
    then(mockAddressRepository).should()
        .saveAll(anyCollection());
  }
}
