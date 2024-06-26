package com.testtask.userdetailsservice.controller.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Range;

@Value
@Builder
public class AddressDto {

  @Range(min = 1000, max = 9999)
  Integer zipCode;

  @NotBlank
  String city;

  @NotBlank
  String street;

  Integer houseNumber;
  String floor;
  Integer apartment;
}
