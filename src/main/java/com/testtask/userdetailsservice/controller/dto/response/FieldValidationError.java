package com.testtask.userdetailsservice.controller.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FieldValidationError {
  String field;
  String message;
}
