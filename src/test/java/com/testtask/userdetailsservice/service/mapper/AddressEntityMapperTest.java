package com.testtask.userdetailsservice.service.mapper;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.service.domain.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressEntityMapperTest {

  private static final java.util.UUID UUID = randomUUID();
  private static final int ZIP_CODE = 2462;
  private static final String CITY = "Budapest";
  private static final String STREET = "Hengermalom út";
  private static final int HOUSE_NUMBER = 13;
  private static final String FLOOR = "5";
  private static final int APARTMENT = 56;

  private AddressEntityMapper underTest;

  @BeforeEach
  void setUp() {
    underTest = new AddressEntityMapper();
  }

  @Test
  void mapShouldReturnAddressEntity() {
    // GIVEN
    var address = createAddress();
    var expected = createAddressEntity();

    // WHEN
    var result = underTest.map(address);

    // THEN
    assertThat(result)
        .usingRecursiveComparison()
        .isEqualTo(expected);
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

  private AddressEntity createAddressEntity() {
    return AddressEntity.builder()
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
