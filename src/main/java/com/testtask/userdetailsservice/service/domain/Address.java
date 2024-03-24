package com.testtask.userdetailsservice.service.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {
  UUID uuid;
  Integer zipCode;
  String city;
  String street;
  Integer houseNumber;
  String floor;
  Integer apartment;
}
