package com.alperensertoglu.controllers;

import com.alperensertoglu.entities.DTO_Employee;
import com.alperensertoglu.entities.Employee;
import com.alperensertoglu.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/employee")
public class EmployeeController {

    // @RestController defines that this class is Controller and adds to Spring Context(IOC)
    // RequestMapping defines base url -> http://localhost:8080/rest/api/xxx

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // http://localhost:8081/rest/v1/employee/list/1
    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(required = true) int id) {
        return employeeService.getEmployeeById(id);
    }

    // http://localhost:8081/rest/v1/employee/with-params?firstName=Alperen&lastName=Sertoğlu
    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeesWithParams(@RequestParam(name = "firstName", required = false) String firstName,
                                                 @RequestParam(name = "lastName", required = false) String lastName) {
        return employeeService.getEmployeesByParams(firstName, lastName);
    }

    @PostMapping(path = "/create-employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name = "id") int id, @RequestBody DTO_Employee request) {
        return employeeService.updateEmployee(id, request);
    }
}
