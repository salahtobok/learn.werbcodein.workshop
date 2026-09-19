package com.webcodein.workshop.employee;

import static org.assertj.core.api.Assertions.assertThat;

import com.webcodein.workshop.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class EmployeeSingletonContainerTest extends AbstractIntegrationTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    void shouldCountEmployees() {
        repository.save(new Employee("Grace"));

        assertThat(repository.count()).isPositive();
    }
}
