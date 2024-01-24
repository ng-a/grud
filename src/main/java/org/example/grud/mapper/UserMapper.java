package org.example.grud.mapper;

import org.example.grud.dto.CustomerDTO;
import org.example.grud.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setFullName(customer.getFullName());

        return customerDTO;
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setId(customerDTO.getId());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setFullName(customerDTO.getFullName());

        return customer;
    }
}
