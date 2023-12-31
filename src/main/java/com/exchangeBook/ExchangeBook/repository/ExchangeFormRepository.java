package com.exchangeBook.ExchangeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exchangeBook.ExchangeBook.entity.ExchangeForm;
import com.exchangeBook.ExchangeBook.entity.ExchangeFormId;

@Repository
public interface ExchangeFormRepository extends JpaRepository<ExchangeForm, ExchangeFormId> {

}
