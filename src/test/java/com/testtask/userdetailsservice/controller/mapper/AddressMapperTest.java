package com.testtask.userdetailsservice.controller.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.testtask.userdetailsservice.controller.dto.request.AddressDto;
import com.testtask.userdetailsservice.service.domain.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressMapperTest {

  private static final int ZIP_CODE = 2462;
  private static final String CITY = "Budapest";
  private static final String STREET = "Hengermalom út";
  private static final int HOUSE_NUMBER = 13;
  private static final String FLOOR = "5";
  private static final int APARTMENT = 56;

  private AddressMapper underTest;

  @BeforeEach
  void setUp() {
    underTest = new AddressMapper();
  }

  @Test
  void mapShouldReturnAddress() {
    // GIVEN
    var addressDto = createAddressDto();
    var expected = createAddress();
    // WHEN
    var result = underTest.map(addressDto);
    // THEN
    assertThat(result).isEqualTo(expected);
  }

  private AddressDto createAddressDto() {
    return AddressDto.builder()
        .zipCode(ZIP_CODE)
        .city(CITY)
        .street(STREET)
        .houseNumber(HOUSE_NUMBER)
        .floor(FLOOR)
        .apartment(APARTMENT)
        .build();
  }

  private Address createAddress() {
    return Address.builder()
        .zipCode(ZIP_CODE)
        .city(CITY)
        .street(STREET)
        .houseNumber(HOUSE_NUMBER)
        .floor(FLOOR)
        .apartment(APARTMENT)
        .build();
  }
}
