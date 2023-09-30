package com.besli.register.service;

import com.besli.register.dto.CustomerDto;
import com.besli.register.dto.CustomerDtoConverter;
import com.besli.register.dto.RegisterCustomerRequest;
import com.besli.register.exception.GetCustomerByPhoneNumberException;
import com.besli.register.model.Customer;
import com.besli.register.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public List<CustomerDto> getAllUser() {
        return customerRepository.findAll().stream().map(customerDtoConverter::converter).collect(Collectors.toList());
    }

    public CustomerDto registerCustomer(RegisterCustomerRequest request) {
        Customer customer = new Customer(request.getName(), request.getSurName(), request.getPhoneNumber(), request.getEmail(), request.getExplanation());
        customerRepository.save(customer);
        return customerDtoConverter.converter(customer);
    }

    public CustomerDto getCustomerByPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new GetCustomerByPhoneNumberException("Müşteri Bulunamadı"));
        return customerDtoConverter.converter(customer);
    }

}
