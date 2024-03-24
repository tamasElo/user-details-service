package com.testtask.userdetailsservice.controller.mapper;

import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.testtask.userdetailsservice.controller.dto.response.AddressDto;
import com.testtask.userdetailsservice.controller.dto.response.UserResponse;
import com.testtask.userdetailsservice.service.domain.Address;
import com.testtask.userdetailsservice.service.domain.User;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserResponseMapperTest {

  private static final UUID UUID = randomUUID();
  private static final String USER = "Test User";
  private static final LocalDate BIRTHDATE = LocalDate.now();
  private static final String PLACE_OF_BIRTH = "Budapest";
  private static final String MOTHER_NAME = "Test User2";
  private static final String SOCIAL_SECURITY_CODE = "123415332";
  private static final String TAX_ID = "979535345";
  private static final String EMAIL = "test.user@example.com";
  private static final String PHONE_NUMBER = "+36 1 1231 3213";

  @Mock
  private Mapper<Address, AddressDto> mockAddressDtoMapper;

  private UserResponseMapper underTest;

  @BeforeEach
  void setUp() {
    underTest = new UserResponseMapper(mockAddressDtoMapper);
  }

  @Test
  void mapShouldReturnUserResponse() {
    // GIVEN
    var address = Address.builder().build();
    var addressDto = AddressDto.builder().build();
    var user = createUser(address);
    var expected = createUserResponse(addressDto);

    given(mockAddressDtoMapper.map(address))
        .willReturn(addressDto);

    // WHEN
    var result = underTest.map(user);

    // THEN
    assertThat(result).isEqualTo(expected);
  }

  private User createUser(Address address) {
    return User.builder()
        .uuid(UUID)
        .name(USER)
        .birthdate(BIRTHDATE)
        .placeOfBirth(PLACE_OF_BIRTH)
        .motherName(MOTHER_NAME)
        .socialSecurityCode(SOCIAL_SECURITY_CODE)
        .taxId(TAX_ID)
        .email(EMAIL)
        .addresses(singletonList(address))
        .phoneNumbers(singletonList(PHONE_NUMBER))
        .build();
  }

  private UserResponse createUserResponse(AddressDto addressDto) {
    return UserResponse.builder()
        .uuid(UUID)
        .name(USER)
        .birthdate(BIRTHDATE)
        .placeOfBirth(PLACE_OF_BIRTH)
        .motherName(MOTHER_NAME)
        .socialSecurityCode(SOCIAL_SECURITY_CODE)
        .taxId(TAX_ID)
        .email(EMAIL)
        .addresses(singletonList(addressDto))
        .phoneNumbers(singletonList(PHONE_NUMBER))
        .build();
  }
}
