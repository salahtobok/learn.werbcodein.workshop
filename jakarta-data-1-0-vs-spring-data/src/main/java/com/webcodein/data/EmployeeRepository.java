package com.webcodein.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // Derived query based on method name
    List<Employee> findByDepartmentAndIsActiveTrue(String department);

    // Custom query
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1 ORDER BY e.lastName ASC")
    List<Employee> findHighEarners(double minSalary);
}
