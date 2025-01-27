package com.ajay.CustomerRecords.Controller;


import com.ajay.CustomerRecords.Entity.CustomerEntity;
import com.ajay.CustomerRecords.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @CrossOrigin(origins = "https://angularspringbootpostgresql.onrender.com")
    @GetMapping("/getdetails")
    public List<CustomerEntity> findall(){
        return customerService.getalldata();

    }

    @CrossOrigin(origins = "https://angularspringbootpostgresql.onrender.com")
    @PostMapping("/saveCustomer")
    public CustomerEntity savedata(@RequestBody CustomerEntity customerEntity){
        return customerService.saveDetails(customerEntity);
    }
    @GetMapping("/getcustomerbyid/{id}")
    public CustomerEntity fetchdetailsbyid(@PathVariable long id){
        return customerService.getcustomerbyid(id);
    }
    @CrossOrigin(origins = "https://angularspringbootpostgresql.onrender.com")
    @PutMapping("/updateCustomer")
    public CustomerEntity updateDetails(@RequestBody CustomerEntity studentEntity){
        return customerService.updateCustomer(studentEntity);
    }
    @CrossOrigin(origins = "https://angularspringbootpostgresql.onrender.com")
    @DeleteMapping("/deleteCustomer/{id}")
    public Boolean deleteDetails(@PathVariable long id){
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/getcustomerbyaddress/{address}")
    public List<CustomerEntity> fetchdetailsbyaddress(@PathVariable String address){
        return customerService.findbyaddress(address);
    }



}
