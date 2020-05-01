package com.example.gate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gate.model.Customer;

@Repository
public interface CustRepo extends JpaRepository<Customer, Long> {

}
