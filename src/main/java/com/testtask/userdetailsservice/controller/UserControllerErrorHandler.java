package com.testtask.userdetailsservice.controller;

import com.testtask.userdetailsservice.controller.dto.response.FieldValidationError;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerErrorHandler {

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<List<FieldValidationError>> handleFieldValidationError(
      MethodArgumentNotValidException ex) {
    var message = createErrorMessages(ex);
    return ResponseEntity.badRequest().body(message);
  }

  private List<FieldValidationError> createErrorMessages(MethodArgumentNotValidException ex) {
    return ex.getFieldErrors().stream()
        .map(this::createErrorMessage)
        .toList();
  }

  private FieldValidationError createErrorMessage(FieldError fieldError) {
    return FieldValidationError.builder()
        .field(fieldError.getField())
        .message(fieldError.getDefaultMessage())
        .build();
  }
}
