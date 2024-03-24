package com.testtask.userdetailsservice.service.mapper;

import static java.util.List.copyOf;

import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.repository.entity.UserEntity;
import com.testtask.userdetailsservice.service.domain.Address;
import com.testtask.userdetailsservice.service.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityMapper implements Mapper<User, UserEntity> {

  private final Mapper<Address, AddressEntity> addressEntityMapper;

  @Override
  public UserEntity map(User user) {
    return UserEntity.builder()
        .uuid(user.getUuid())
        .name(user.getName())
        .birthdate(user.getBirthdate())
        .placeOfBirth(user.getPlaceOfBirth())
        .motherName(user.getMotherName())
        .socialSecurityCode(user.getSocialSecurityCode())
        .taxId(user.getTaxId())
        .email(user.getEmail())
        .addresses(createAddressEntities(user.getAddresses()))
        .phoneNumbers(copyOf(user.getPhoneNumbers()))
        .build();
  }

  private List<AddressEntity> createAddressEntities(List<Address> addresses) {
    return addresses.stream()
        .map(addressEntityMapper::map)
        .toList();
  }
}
