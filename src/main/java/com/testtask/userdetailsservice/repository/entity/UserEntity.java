package com.testtask.userdetailsservice.repository.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

  @Id
  @GeneratedValue(generator = "uuid-hibernate-generator")
  @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID uuid;

  private String name;
  private LocalDate birthdate;
  private String placeOfBirth;
  private String motherName;
  private String socialSecurityCode;
  private String taxId;
  private String email;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<AddressEntity> addresses;

  @ElementCollection
  @CollectionTable(name = "phone_numbers")
  private List<String> phoneNumbers;
}
