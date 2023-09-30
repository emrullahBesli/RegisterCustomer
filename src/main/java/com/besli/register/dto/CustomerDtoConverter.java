package com.besli.register.dto;

import com.besli.register.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public  CustomerDto converter(Customer customer) {
        return new CustomerDto(customer.getName(), customer.getSurName(), customer.getPhoneNumber(),customer.getEmail(), customer.getExplanation(), customer.getDate());
    }
}
