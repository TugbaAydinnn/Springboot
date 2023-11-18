package com.work.customer.Repositories;

import com.work.customer.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailEquals(String email);

    Optional<Customer> findByCidEquals(Long cid);

    long deleteByCid(Long cid);





}