package com.testtask.userdetailsservice.controller.dto.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddressDto {
  int zipCode;
  UUID uuid;
  String city;
  String street;
  int houseNumber;
  String floor;
  int apartment;
}
