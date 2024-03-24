package com.testtask.userdetailsservice.controller.mapper;

import com.testtask.userdetailsservice.controller.dto.response.AddressDto;
import com.testtask.userdetailsservice.service.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoMapper implements Mapper<Address, AddressDto> {

  @Override
  public AddressDto map(Address address) {
    return AddressDto.builder()
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
