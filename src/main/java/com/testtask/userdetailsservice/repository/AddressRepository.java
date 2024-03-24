package com.testtask.userdetailsservice.repository;

import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {
  List<AddressEntity> findByUserUuid(UUID uuid);
}
