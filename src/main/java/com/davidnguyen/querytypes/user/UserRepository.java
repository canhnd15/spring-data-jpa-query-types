package com.davidnguyen.querytypes.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(value = "User.detail", type = EntityGraph.EntityGraphType.FETCH)
    List<User> findByStatus(String status);
}
