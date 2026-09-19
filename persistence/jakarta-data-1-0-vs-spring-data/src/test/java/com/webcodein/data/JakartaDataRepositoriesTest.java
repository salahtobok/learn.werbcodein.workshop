package com.webcodein.data;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.data.Order;
import jakarta.data.Sort;
import jakarta.data.page.PageRequest;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Uses the repository implementations that hibernate-processor generates at compile time
 * (EmployeeRepository_ and ProductRepository_), backed by an in-memory H2 database.
 */
class JakartaDataRepositoriesTest {

    static SessionFactory sessionFactory;
    static StatelessSession session;

    @BeforeAll
    static void setUp() {
        sessionFactory = new Configuration()
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Product.class)
            .setProperty("hibernate.connection.url", "jdbc:h2:mem:workshop;DB_CLOSE_DELAY=-1")
            .setProperty("hibernate.hbm2ddl.auto", "create-drop")
            .buildSessionFactory();
        session = sessionFactory.openStatelessSession();
    }

    @AfterAll
    static void tearDown() {
        session.close();
        sessionFactory.close();
    }

    @Test
    void derivedAndCustomQueries() {
        EmployeeRepository employees = new EmployeeRepository_(session);
        employees.insert(new Employee(1L, "Lovelace", "R&D", 200_000, true));
        employees.insert(new Employee(2L, "Hopper", "R&D", 50_000, false));

        assertThat(employees.activeInDepartment("R&D", true)).hasSize(1);
        assertThat(employees.findHighEarners(100_000)).hasSize(1);
    }

    @Test
    void pagination() {
        ProductRepository products = new ProductRepository_(session);
        products.insert(new Product(1L, "Phone", "Electronics", 500));
        products.insert(new Product(2L, "Cable", "Electronics", 10));

        var page = products.byCategory("Electronics",
            PageRequest.ofPage(1).size(20), Order.by(Sort.asc("price")));

        assertThat(page.content()).extracting(Product::getName).containsExactly("Cable", "Phone");
    }
}
