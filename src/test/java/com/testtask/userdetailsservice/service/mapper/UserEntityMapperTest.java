package com.testtask.userdetailsservice.service.mapper;

import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.testtask.userdetailsservice.repository.entity.AddressEntity;
import com.testtask.userdetailsservice.repository.entity.UserEntity;
import com.testtask.userdetailsservice.service.domain.Address;
import com.testtask.userdetailsservice.service.domain.User;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserEntityMapperTest {

  private static final java.util.UUID UUID = randomUUID();
  private static final String USER = "Test User";
  private static final LocalDate BIRTHDATE = LocalDate.now();
  private static final String PLACE_OF_BIRTH = "Budapest";
  private static final String MOTHER_NAME = "Test User2";
  private static final String SOCIAL_SECURITY_CODE = "123415332";
  private static final String TAX_ID = "979535345";
  private static final String EMAIL = "test.user@example.com";
  private static final String PHONE_NUMBER = "+36 1 1231 3213";

  @Mock
  private Mapper<Address, AddressEntity> mockAddressEntityMapper;

  private UserEntityMapper underTest;

  @BeforeEach
  void setUp() {
    underTest = new UserEntityMapper(mockAddressEntityMapper);
  }

  @Test
  void mapShouldReturnUserEntity() {
    // GIVEN
    var address = Address.builder().build();
    var addressEntity = AddressEntity.builder().build();
    var user = createUser(address);
    var userEntity = createUserEntity(addressEntity);
    addressEntity.setUser(userEntity);

    given(mockAddressEntityMapper.map(address))
        .willReturn(addressEntity);

    // WHEN
    var result = underTest.map(user);

    // THEN
    assertThat(result)
        .usingRecursiveComparison()
        .isEqualTo(userEntity);
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

  private UserEntity createUserEntity(AddressEntity addressEntity) {
    return UserEntity.builder()
        .uuid(UUID)
        .name(USER)
        .birthdate(BIRTHDATE)
        .placeOfBirth(PLACE_OF_BIRTH)
        .motherName(MOTHER_NAME)
        .socialSecurityCode(SOCIAL_SECURITY_CODE)
        .taxId(TAX_ID)
        .email(EMAIL)
        .addresses(singletonList(addressEntity))
        .phoneNumbers(singletonList(PHONE_NUMBER))
        .build();
  }
}
