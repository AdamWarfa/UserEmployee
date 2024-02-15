package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.UserRepository;
import com.example.useremployee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setEmail("userOne@gmail.com");
        user1.setPassword("userOne");
        userRepository.save(user1);

        user1.setUserID(0);
        user1.setEmail("kurt@gmail.com");
        user1.setPassword("kurt");
        userRepository.save(user1);

        user1.setUserID(0);
        user1.setEmail("Jens@gmail.com");
        user1.setPassword("Jens");
        userRepository.save(user1);

        Employee employee1 = new Employee();
        employee1.setBorn(LocalDateTime.of(1990, 1, 1, 0, 0));
        employee1.setName("Jens");
        employee1.setGender(Gender.MALE);
        employee1.setVegetarian(false);
        employee1.setUser(user1);
        employeeRepository.save(employee1);
    }
}
