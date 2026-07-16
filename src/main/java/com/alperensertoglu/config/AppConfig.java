package com.alperensertoglu.config;

import com.alperensertoglu.entities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alperen", "Sertoğlu"));
        employees.add(new Employee(2, "Jon", "Snow"));
        employees.add(new Employee(3, "Darth", "Vader"));
        employees.add(new Employee(4, "Harry", "Potter"));
        employees.add(new Employee(5, "Harry", "Styles"));
        return employees;
    }
}
