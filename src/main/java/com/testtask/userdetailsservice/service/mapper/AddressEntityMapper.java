package com.testtask.userdetailsservice.service.mapper;

import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.service.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityMapper implements Mapper<Address, AddressEntity> {

  @Override
  public AddressEntity map(Address address) {
    return AddressEntity.builder()
        .uuid(address.getUuid())
        .zipCode(address.getZipCode())
        .city(address.getCity())
        .street(address.getStreet())
        .houseNumber(address.getHouseNumber())
        .floor(address.getFloor())
        .apartment(address.getApartment())
        .build();
  }
}
