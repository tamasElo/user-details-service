package com.testtask.userdetailsservice.controller.mapper;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import com.testtask.userdetailsservice.controller.dto.response.AddressDto;
import com.testtask.userdetailsservice.service.domain.Address;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressDtoMapperTest {

  private static final UUID UUID = randomUUID();
  private static final int ZIP_CODE = 2462;
  private static final String CITY = "Budapest";
  private static final String STREET = "Hengermalom út";
  private static final int HOUSE_NUMBER = 13;
  private static final String FLOOR = "5";
  private static final int APARTMENT = 56;

  private AddressDtoMapper underTest;

  @BeforeEach
  void setUp() {
    underTest = new AddressDtoMapper();
  }

  @Test
  void mapShouldReturnAddressDto() {
    // GIVEN
    var address = createAddress();
    var expected = createAddressDto();
    // WHEN
    var result = underTest.map(address);
    // THEN
    assertThat(result).isEqualTo(expected);
  }

  private Address createAddress() {
    return Address.builder()
        .uuid(UUID)
        .zipCode(ZIP_CODE)
        .city(CITY)
        .street(STREET)
        .houseNumber(HOUSE_NUMBER)
        .floor(FLOOR)
        .apartment(APARTMENT)
        .build();
  }

  private AddressDto createAddressDto() {
    return AddressDto.builder()
        .uuid(UUID)
        .zipCode(ZIP_CODE)
        .city(CITY)
        .street(STREET)
        .houseNumber(HOUSE_NUMBER)
        .floor(FLOOR)
        .apartment(APARTMENT)
        .build();
  }
}
