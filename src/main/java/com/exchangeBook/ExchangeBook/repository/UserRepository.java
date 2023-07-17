package com.exchangeBook.ExchangeBook.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exchangeBook.ExchangeBook.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
