package com.webcodein.shop.employee;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee, Long> {

    Employee save(Employee employee);

    // Window function directly in HQL
    @Query("""
        SELECT e.name, e.salary,
               RANK() OVER(PARTITION BY e.department ORDER BY e.salary DESC) as dept_rank
        FROM Employee e
    """)
    List<Object[]> findEmployeesWithDepartmentRank();
}
