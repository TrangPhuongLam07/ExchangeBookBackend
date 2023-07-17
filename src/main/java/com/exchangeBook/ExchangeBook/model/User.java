package com.exchangeBook.ExchangeBook.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

//@Entity
//@Table(name = "users")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class User implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 5851090990707599604L;
//    @Id
//    @GeneratedValue
//    private UUID id;
//    private String userName;
//    private String password;
//    private String firstName;
//    private String lastName;
//    private String phoneNumber;
//    private String address;
//    private String email;
//    private boolean isEmailVerified;
//    private int gender;
//
//    @OneToMany(mappedBy = "owner")
//    private Set<Book> books;
//
//}
