package com.davidnguyen.querytypes.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
        SELECT
            concat(u.firstName, ' ', u.lastName) as fullName,
            u.email as email,
            concat( a.street, ', ', a.city, ', ', a.state) as fullAddress,
            a.country as country,
            a.zipCode as zipCode
        FROM tbl_user u
        LEFT JOIN tbl_address a ON  u.address.id = a.id
    """)
    List<UserInfoProjection> findAllUserInfo();

    interface UserInfoProjection {
        String getFullName();
        String getEmail();
        String getFullAddress();
        String getCountry();
        String getZipCode();
    }
}
