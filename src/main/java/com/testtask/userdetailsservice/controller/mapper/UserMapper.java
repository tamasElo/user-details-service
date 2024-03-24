package com.testtask.userdetailsservice.controller.mapper;

import static java.util.List.copyOf;

import com.testtask.userdetailsservice.controller.dto.request.AddressDto;
import com.testtask.userdetailsservice.controller.dto.request.CreateUserRequest;
import com.testtask.userdetailsservice.service.domain.Address;
import com.testtask.userdetailsservice.service.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<CreateUserRequest, User> {

  private final Mapper<AddressDto, Address> addressMapper;

  @Override
  public User map(CreateUserRequest createUserRequest) {
    return User.builder()
        .name(createUserRequest.getName())
        .birthdate(createUserRequest.getBirthdate())
        .placeOfBirth(createUserRequest.getPlaceOfBirth())
        .motherName(createUserRequest.getMotherName())
        .socialSecurityCode(createUserRequest.getSocialSecurityCode())
        .taxId(createUserRequest.getTaxId())
        .email(createUserRequest.getEmail())
        .addresses(createAddresses(createUserRequest.getAddresses()))
        .phoneNumbers(copyOf(createUserRequest.getPhoneNumbers()))
        .build();
  }

  private List<Address> createAddresses(List<AddressDto> addresses) {
    return addresses.stream()
        .map(addressMapper::map)
        .toList();
  }
}
