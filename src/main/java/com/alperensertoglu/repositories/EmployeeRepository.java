package com.alperensertoglu.repositories;

import com.alperensertoglu.entities.DTO_Employee;
import com.alperensertoglu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeRepository {

    @Autowired
    private List<Employee> employees;

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee findEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeesWithParams(String firstName, String lastName) {
        List<Employee> findEmployees = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employees;
        }
        for (Employee employee : employees) {
            if (firstName != null && lastName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    findEmployees.add(employee);
                }
            } else if (firstName != null && lastName == null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    findEmployees.add(employee);
                }
            } else if (firstName == null && lastName != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    findEmployees.add(employee);
                }
            }

        }
        return findEmployees;
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public boolean deleteEmployee(int id) {
        boolean deleted = true;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                break;
            } else
                deleted = false;
        }
        return deleted;
    }

    public Employee updateEmployee(int id, DTO_Employee request) {
        Employee findEmployee = null;
        for (Employee employee1 : employees) {
            if (employee1.getId() == id) {
                findEmployee = employee1;
                break;
            }
        }
        findEmployee.setFirstName(request.getFirstName());
        findEmployee.setLastName(request.getLastName());
        return findEmployee;
    }
}
