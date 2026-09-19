package com.webcodein.shop.user;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {

    // Spring Data maps the columns to the Java record projection
    List<UserSummary> findByIsActiveTrue();
}
