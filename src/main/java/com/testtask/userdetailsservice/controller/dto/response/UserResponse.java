package com.testtask.userdetailsservice.controller.dto.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(NON_NULL)
public class UserResponse {
  UUID uuid;
  String name;
  LocalDate birthdate;
  String placeOfBirth;
  String motherName;
  String socialSecurityCode;
  String taxId;
  String email;
  List<AddressDto> addresses;
  List<String> phoneNumbers;
}
