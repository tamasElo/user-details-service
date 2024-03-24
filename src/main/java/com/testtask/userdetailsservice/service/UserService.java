package com.testtask.userdetailsservice.service;

import com.testtask.userdetailsservice.service.domain.User;
import java.util.List;

public interface UserService {

  User createUser(User user);

  List<User> getUsers();
}
