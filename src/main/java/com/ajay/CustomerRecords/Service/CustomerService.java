package com.ajay.CustomerRecords.Service;

import com.ajay.CustomerRecords.Entity.CustomerEntity;
import com.ajay.CustomerRecords.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<CustomerEntity> getalldata(){
        return customerRepo.findAll(Sort.by("id").ascending());
    }

    public CustomerEntity getcustomerbyid(long id){
        return customerRepo.findById(id).orElse(null);
    }

    public CustomerEntity saveDetails(CustomerEntity customerEntity){

        return customerRepo.save(customerEntity);

    }

    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {

        CustomerEntity customerEntityupdate=customerRepo.findById(customerEntity.getId()).orElse(null);

        if(customerEntityupdate!=null){
            customerEntityupdate.setName(customerEntity.getName());
            customerEntityupdate.setEmail(customerEntity.getEmail());
            customerEntityupdate.setAddress(customerEntity.getAddress());

            customerRepo.save(customerEntityupdate);
            return customerEntityupdate;
        }

        return null;
    }

    public Boolean deleteCustomer(Long id){

        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            return true;

        }

        return false;

    }


}
