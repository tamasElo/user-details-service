package com.testtask.userdetailsservice.controller;

import com.testtask.userdetailsservice.controller.dto.CreateUserRequest;
import com.testtask.userdetailsservice.controller.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user-details-service/users")
public class UserDetailsController {

  @PostMapping
  public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
    return ResponseEntity.ok(UserResponse.builder()
            .name(createUserRequest.getName())
            .birthdate(createUserRequest.getBirthdate())
            .placeOfBirth(createUserRequest.getPlaceOfBirth())
            .motherName(createUserRequest.getMotherName())
            .socialSecurityCode(createUserRequest.getSocialSecurityCode())
            .taxId(createUserRequest.getTaxId())
            .email(createUserRequest.getEmail())
            .addresses(createUserRequest.getAddresses())
            .phoneNumbers(createUserRequest.getPhoneNumbers())
        .build());
  }
}
