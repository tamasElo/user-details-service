package com.testtask.userdetailsservice.controller.mapper;

import com.testtask.userdetailsservice.controller.dto.request.AddressDto;
import com.testtask.userdetailsservice.service.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<AddressDto, Address> {

  @Override
  public Address map(AddressDto addressDto) {
    return Address.builder()
        .zipCode(addressDto.getZipCode())
        .city(addressDto.getCity())
        .street(addressDto.getStreet())
        .houseNumber(addressDto.getHouseNumber())
        .floor(addressDto.getFloor())
        .apartment(addressDto.getApartment())
        .build();
  }
}
