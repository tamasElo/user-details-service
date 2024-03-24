package com.testtask.userdetailsservice.repository.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressEntity {

  @Id
  @GeneratedValue(generator = "uuid-hibernate-generator")
  @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID uuid;

  @ManyToOne
  @JoinColumn(name = "user_uuid")
  @Setter
  private UserEntity user;

  private Integer zipCode;
  private String city;
  private String street;
  private Integer houseNumber;
  private String floor;
  private Integer apartment;
}
