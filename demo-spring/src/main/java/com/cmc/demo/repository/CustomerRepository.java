package com.cmc.demo.repository;

import com.cmc.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Customer repository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Modifying
    @Transactional
    int deleteById(Integer integer);
}
