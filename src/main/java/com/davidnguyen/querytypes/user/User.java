package com.davidnguyen.querytypes.user;

import com.davidnguyen.querytypes.address.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tbl_user")
@NamedQuery(name = "User.findByStatusAndCity",
        query = "SELECT u FROM tbl_user u JOIN u.address a WHERE u.status = ?1 AND a.city = ?2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
