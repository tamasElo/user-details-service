package com.testtask.userdetailsservice.controller.dto;

import java.util.List;
import lombok.Value;

@Value
public class CreateUserRequest {
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
