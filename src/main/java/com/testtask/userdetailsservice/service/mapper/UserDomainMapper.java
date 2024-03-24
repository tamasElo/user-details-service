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
public class UserDomainMapper implements Mapper<UserEntity, User> {

  private final Mapper<AddressEntity, Address> addressMapper;

  @Override
  public User map(UserEntity userEntity) {
    return User.builder()
        .uuid(userEntity.getUuid())
        .name(userEntity.getName())
        .birthdate(userEntity.getBirthdate())
        .placeOfBirth(userEntity.getPlaceOfBirth())
        .motherName(userEntity.getMotherName())
        .socialSecurityCode(userEntity.getSocialSecurityCode())
        .taxId(userEntity.getTaxId())
        .email(userEntity.getEmail())
        .addresses(createAddressEntities(userEntity.getAddresses()))
        .phoneNumbers(copyOf(userEntity.getPhoneNumbers()))
        .build();
  }

  private List<Address> createAddressEntities(List<AddressEntity> addressEntities) {
    return addressEntities.stream()
        .map(addressMapper::map)
        .toList();
  }
}
