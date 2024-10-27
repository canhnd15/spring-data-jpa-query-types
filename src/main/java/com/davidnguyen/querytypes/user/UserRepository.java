package com.davidnguyen.querytypes.user;

import com.davidnguyen.querytypes.address.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager entityManager;

    public List<User> findUsersByStatusAndCity(String status, String city) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cbQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = cbQuery.from(User.class);
        Join<User, Address> address = user.join("address", JoinType.INNER);

        Predicate statusPredicate = criteriaBuilder.equal(user.get("status"), status);
        Predicate cityPredicate = criteriaBuilder.equal(address.get("city"), city);

        cbQuery.select(user).where(criteriaBuilder.and(statusPredicate, cityPredicate));

        return entityManager.createQuery(cbQuery).getResultList();
    }
}
