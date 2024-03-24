package com.testtask.userdetailsservice.repository;

import com.testtask.userdetailsservice.repository.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
