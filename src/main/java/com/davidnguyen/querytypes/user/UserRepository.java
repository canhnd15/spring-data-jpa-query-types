package com.davidnguyen.querytypes.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM tbl_user u JOIN u.address a WHERE u.status = :status AND a.city = :city")
    List<User> findUsersByStatusAndCity(@Param("status") String status, @Param("city") String city);
}
