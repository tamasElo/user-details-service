package com.testtask.userdetailsservice.controller.dto.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddressDto {
  UUID uuid;
  int zipCode;
  String city;
  String street;
  int houseNumber;
  String floor;
  int apartment;
}
