package com.example.demo.pojo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value="select * from customer where last_name like CONCAT(''%'',?1,'%') ",nativeQuery = true)
    List<Customer> findByLastName(String lastName);
}