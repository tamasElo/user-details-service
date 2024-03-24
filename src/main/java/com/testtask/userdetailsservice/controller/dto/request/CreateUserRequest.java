package com.testtask.userdetailsservice.controller.dto.request;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import lombok.Value;

@Value
public class CreateUserRequest {

  @Pattern(
      regexp = "^([a-zA-Z\\xC0-\\uFFFF]+([ \\-']?[a-zA-Z\\xC0-\\uFFFF]+)*[.]?){1,2}$",
      message = "must be a valid name")
  String name;

  @PastOrPresent
  LocalDate birthdate;

  @NotBlank
  String placeOfBirth;

  @Pattern(
      regexp = "^([a-zA-Z\\xC0-\\uFFFF]+([ \\-']?[a-zA-Z\\xC0-\\uFFFF]+)*[.]?){1,2}$",
      message = "must be a valid name")
  String motherName;

  @Pattern(
      regexp = "^\\d{3}[-| ]?\\d{3}[-| ]?\\d{3}$",
      message = "must contain 9 digits in one piece or "
          + "separated by hyphen or space at every third digit")
  String socialSecurityCode;

  @Pattern(
      regexp = "\\d{10}",
      message = "must consist of 10 digits")
  String taxId;

  @Email
  String email;

  @NotNull
  @Valid
  List<AddressDto> addresses;

  @NotNull
  List<@Pattern(
      regexp = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s\\./0-9]*$",
      message = "must be a valid phone number") String> phoneNumbers;
}
