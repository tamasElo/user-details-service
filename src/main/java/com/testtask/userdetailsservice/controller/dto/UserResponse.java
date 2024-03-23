package com.testtask.userdetailsservice.controller.dto;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {
  UUID uuid;
  String name;
  String birthdate;
  String placeOfBirth;
  String motherName;
  String socialSecurityCode;
  String taxId;
  String email;
  List<String> addresses;
  List<String> phoneNumbers;
}
