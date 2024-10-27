package com.davidnguyen.querytypes.user;

import com.davidnguyen.querytypes.address.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tbl_user")
@NamedEntityGraph(name = "User.detail", attributeNodes = @NamedAttributeNode("address"))
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
