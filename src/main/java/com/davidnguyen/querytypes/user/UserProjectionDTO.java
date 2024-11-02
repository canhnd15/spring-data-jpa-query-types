package com.davidnguyen.querytypes.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserProjectionDTO {
    private final String fullName;
    private final String email;
    private final String address;
    private final String country;
    private final String zipCode;

    public UserProjectionDTO(String fullName, String email, String address, String country, String zipCode) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.country = country;
        this.zipCode = zipCode;
    }
}
