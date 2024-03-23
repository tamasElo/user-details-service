package com.testtask.userdetailsservice.controller.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {
  UUID uuid;
  String name;
  LocalDate birthdate;
  String placeOfBirth;
  String motherName;
  String socialSecurityCode;
  String taxId;
  String email;
  List<Address> addresses;
  List<String> phoneNumbers;
}
