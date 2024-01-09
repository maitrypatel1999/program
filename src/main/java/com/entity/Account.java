package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long clientId;

  private Long groupId;

//  @NotBlank(message = "Account number must not be blank")
  private Long acctNumber;

  private String acctHolder;

  private String acctName;

  private String acctType;

  private Double acctBalance;

}
