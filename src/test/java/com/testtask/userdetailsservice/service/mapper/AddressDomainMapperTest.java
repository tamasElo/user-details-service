package com.testtask.userdetailsservice.service.mapper;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.service.domain.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressDomainMapperTest {

  private static final java.util.UUID UUID = randomUUID();
  private static final int ZIP_CODE = 2462;
  private static final String CITY = "Budapest";
  private static final String STREET = "Hengermalom út";
  private static final int HOUSE_NUMBER = 13;
  private static final String FLOOR = "5";
  private static final int APARTMENT = 56;

  private AddressDomainMapper underTest;

  @BeforeEach
  void setUp() {
    underTest = new AddressDomainMapper();
  }

  @Test
  void mapShouldReturnAddress() {
    // GIVEN
    var addressEntity = createAddressEntity();
    var expected = createAddress();

    // WHEN
    var result = underTest.map(addressEntity);

    // THEN
    assertThat(result).isEqualTo(expected);
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
}
