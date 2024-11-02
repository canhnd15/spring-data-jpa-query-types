package com.davidnguyen.querytypes.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
        """
            SELECT new com.davidnguyen.querytypes.user.UserProjectionDTO(
                concat(u.firstName, ' ', u.lastName),
                u.email,
                concat(a.street, ', ', a.city, ', ', a.state),
                a.country,
                a.zipCode
            )
            FROM tbl_user u LEFT JOIN tbl_address a ON u.address.id = a.id
        """
    )
    List<UserProjectionDTO> findAllUserInfo();
}
