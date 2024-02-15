package com.example.useremployee.repositories;

import com.example.useremployee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findEmployeeByName() {
        List<Employee> employees = employeeRepository.findEmployeeByName("Jens");
        assertFalse(employees.isEmpty());
    }

    @Test
    void testDeleteEmployee() {
        List<Employee> employees = employeeRepository.findEmployeeByName("Jens");
        Employee employee = employees.get(0);
        assertEquals("Jens", employee.getName());
        employeeRepository.delete(employee.getUser());
    }

}