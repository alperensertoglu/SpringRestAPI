package com.alperensertoglu.services;

import com.alperensertoglu.entities.DTO_Employee;
import com.alperensertoglu.entities.Employee;
import com.alperensertoglu.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeesByParams(String firstName, String lastName) {
        return employeeRepository.getEmployeesWithParams(firstName, lastName);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(int id, DTO_Employee request) {
        return employeeRepository.updateEmployee(id, request);
    }
}
