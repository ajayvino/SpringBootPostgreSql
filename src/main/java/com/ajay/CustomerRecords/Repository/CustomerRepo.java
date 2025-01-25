package com.ajay.CustomerRecords.Repository;

import com.ajay.CustomerRecords.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {
}
