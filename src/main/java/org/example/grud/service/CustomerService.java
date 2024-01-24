package org.example.grud.service;

import lombok.extern.slf4j.Slf4j;
import org.example.grud.dto.CustomerDTO;
import org.example.grud.mapper.UserMapper;
import org.example.grud.model.Customer;
import org.example.grud.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CustomerService {

    private final UserMapper userMapper;
    private final CustomerRepository customerRepository;

    public CustomerService(UserMapper userMapper, CustomerRepository customerRepository) {
        this.userMapper = userMapper;
        this.customerRepository = customerRepository;
    }


    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = userMapper.toEntity(customerDTO);
        customerRepository.save(customer);

        log.info("Customer created: {}", customer);
        return userMapper.toDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers =
                customerRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();

        log.info("Customers found: {}", customers);
        return customers;
    }


    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(userMapper::toDTO);
    }

    public Optional<CustomerDTO> updateCustomer(Long id, CustomerDTO customerDTO) {
        if (customerRepository.existsById(id)) {
            Customer customer = userMapper.toEntity(customerDTO);

            customerRepository.deleteById(id);
            customerRepository.save(customer);

            log.info("Customer updated: {}", customer);
            return Optional.ofNullable(userMapper.toDTO(customer));
        }

        log.warn("Customer not found: {}", id);
        return Optional.empty();
    }

    public void deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.set_active(false);

            customerRepository.save(customer);
            log.info("Customer deleted: {}", customer);
        } else {
            log.warn("Customer not found: {}", id);
        }
    }
}
