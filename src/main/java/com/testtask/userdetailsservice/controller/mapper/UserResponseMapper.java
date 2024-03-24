package com.testtask.userdetailsservice.controller.mapper;

import static java.util.List.copyOf;

import com.testtask.userdetailsservice.controller.dto.response.AddressDto;
import com.testtask.userdetailsservice.controller.dto.response.UserResponse;
import com.testtask.userdetailsservice.service.domain.Address;
import com.testtask.userdetailsservice.service.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserResponseMapper implements Mapper<User, UserResponse> {

  private final Mapper<Address, AddressDto> addressDtoMapper;

  @Override
  public UserResponse map(User user) {
    return UserResponse.builder()
        .uuid(user.getUuid())
        .name(user.getName())
        .birthdate(user.getBirthdate())
        .placeOfBirth(user.getPlaceOfBirth())
        .motherName(user.getMotherName())
        .socialSecurityCode(user.getSocialSecurityCode())
        .taxId(user.getTaxId())
        .email(user.getEmail())
        .addresses(createAddresses(user.getAddresses()))
        .phoneNumbers(copyOf(user.getPhoneNumbers()))
        .build();
  }

  private List<AddressDto> createAddresses(List<Address> addresses) {
    return addresses.stream()
        .map(addressDtoMapper::map)
        .toList();
  }
}
