package com.testtask.userdetailsservice.service;

import com.testtask.userdetailsservice.repository.UserRepository;
import com.testtask.userdetailsservice.repository.entity.UserEntity;
import com.testtask.userdetailsservice.service.domain.User;
import com.testtask.userdetailsservice.service.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

  private final UserRepository userRepository;
  private final Mapper<User, UserEntity> userEntityMapper;
  private final Mapper<UserEntity, User> userMapper;

  @Override
  public User createUser(User user) {
    var userEntity = userRepository.save(userEntityMapper.map(user));
    return userMapper.map(userEntity);
  }
}
