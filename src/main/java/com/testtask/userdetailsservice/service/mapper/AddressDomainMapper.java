package com.testtask.userdetailsservice.service.mapper;

import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.service.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDomainMapper implements Mapper<AddressEntity, Address> {

  @Override
  public Address map(AddressEntity addressEntity) {
    return Address.builder()
        .uuid(addressEntity.getUuid())
        .zipCode(addressEntity.getZipCode())
        .city(addressEntity.getCity())
        .street(addressEntity.getStreet())
        .houseNumber(addressEntity.getHouseNumber())
        .floor(addressEntity.getFloor())
        .apartment(addressEntity.getApartment())
        .build();
  }
}
