package com.testtask.userdetailsservice.service.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {
  UUID uuid;
  int zipCode;
  String city;
  String street;
  int houseNumber;
  String floor;
  int apartment;
}
