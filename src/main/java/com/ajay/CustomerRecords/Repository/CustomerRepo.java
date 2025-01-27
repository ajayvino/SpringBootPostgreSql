package com.ajay.CustomerRecords.Repository;

import com.ajay.CustomerRecords.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {

    List<CustomerEntity> findByAddress(String address);





}
