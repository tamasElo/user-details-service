package com.testtask.userdetailsservice.controller;

import com.testtask.userdetailsservice.controller.dto.request.CreateUserRequest;
import com.testtask.userdetailsservice.controller.dto.response.Address;
import com.testtask.userdetailsservice.controller.dto.response.UserResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/v1/user-details-service/users")
public class UserDetailsController {

  private static Address createAddress(
      com.testtask.userdetailsservice.controller.dto.request.Address address) {
    return Address.builder()
        .zipCode(address.getZipCode())
        .city(address.getCity())
        .street(address.getStreet())
        .houseNumber(address.getHouseNumber())
        .floor(address.getFloor())
        .apartment(address.getApartment())
        .build();
  }

  @PostMapping
  public ResponseEntity<UserResponse> createUser(
      @Valid @RequestBody CreateUserRequest createUserRequest) {
    return ResponseEntity.ok(createUserResponse(createUserRequest));
  }

  private UserResponse createUserResponse(CreateUserRequest createUserRequest) {
    return UserResponse.builder()
        .name(createUserRequest.getName())
        .birthdate(createUserRequest.getBirthdate())
        .placeOfBirth(createUserRequest.getPlaceOfBirth())
        .motherName(createUserRequest.getMotherName())
        .socialSecurityCode(createUserRequest.getSocialSecurityCode())
        .taxId(createUserRequest.getTaxId())
        .email(createUserRequest.getEmail())
        .addresses(createAddresses(createUserRequest))
        .phoneNumbers(createUserRequest.getPhoneNumbers())
        .build();
  }

  private List<Address> createAddresses(CreateUserRequest createUserRequest) {
    return createUserRequest.getAddresses().stream()
        .map(UserDetailsController::createAddress)
        .toList();
  }
}
