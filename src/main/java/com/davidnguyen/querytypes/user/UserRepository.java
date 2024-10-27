package com.davidnguyen.querytypes.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstNameAndAddress_City(String firstName, String city);
    List<User> findByStatusAndAddress_Country(String status, String country);
}
