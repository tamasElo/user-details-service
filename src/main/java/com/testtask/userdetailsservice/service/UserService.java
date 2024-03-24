package com.testtask.userdetailsservice.service;

import com.testtask.userdetailsservice.service.domain.User;
import java.util.List;
import java.util.UUID;

public interface UserService {

  User createUser(User user);

  List<User> getUsers();

  void depersonalizeUser(UUID uuid);
}
