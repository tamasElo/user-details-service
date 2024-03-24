package com.testtask.userdetailsservice.service;

import com.testtask.userdetailsservice.repository.AddressRepository;
import com.testtask.userdetailsservice.repository.UserRepository;
import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.repository.entity.UserEntity;
import com.testtask.userdetailsservice.service.domain.User;
import com.testtask.userdetailsservice.service.mapper.Mapper;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

  private final UserRepository userRepository;
  private final AddressRepository addressRepository;
  private final Mapper<User, UserEntity> userEntityMapper;
  private final Mapper<UserEntity, User> userMapper;

  @Override
  public User createUser(User user) {
    var userEntity = userRepository.save(userEntityMapper.map(user));
    return userMapper.map(userEntity);
  }

  @Override
  public List<User> getUsers() {
    var userEntities = userRepository.findAll();
    return StreamSupport.stream(userEntities.spliterator(), false)
        .map(userMapper::map)
        .toList();
  }

  @Override
  public void depersonalizeUser(UUID uuid) {
    depersonalizeAddresses(uuid);
    userRepository.save(UserEntity.builder().uuid(uuid).build());
  }

  private void depersonalizeAddresses(UUID uuid) {
    var depersonalizedAddresses = addressRepository.findByUserUuid(uuid).stream()
        .map(this::depersonalizeAddress)
        .toList();
    addressRepository.saveAll(depersonalizedAddresses);
  }

  private AddressEntity depersonalizeAddress(AddressEntity addressEntity) {
    return AddressEntity.builder()
        .uuid(addressEntity
            .getUuid())
        .build();
  }
}
