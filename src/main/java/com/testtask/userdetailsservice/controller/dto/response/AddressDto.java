package com.testtask.userdetailsservice.controller.dto.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(NON_NULL)
public class AddressDto {
  UUID uuid;
  Integer zipCode;
  String city;
  String street;
  Integer houseNumber;
  String floor;
  Integer apartment;
}
