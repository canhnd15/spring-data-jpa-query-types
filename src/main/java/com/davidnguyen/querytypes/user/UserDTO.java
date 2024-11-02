package com.davidnguyen.querytypes.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Builder
@Setter
@Getter
public class UserDTO {
    private String fullName;
    private String email;
    private String address;
    private String country;
    private String zipCode;

    public static UserDTO of(UserRepository.UserInfoProjection entity) {
        if (Objects.isNull(entity))
            return null;

        return UserDTO.builder()
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .address(entity.getFullAddress())
                .country(entity.getCountry())
                .zipCode(entity.getZipCode())
                .build();
    }
}
