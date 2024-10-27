package com.davidnguyen.querytypes.user;

import org.springframework.data.jpa.domain.Specification;

public class UserSpec {

    public static Specification<User> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<User> hasCity(String city) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("address").get("city"), city));
    }

}
