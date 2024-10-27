package com.davidnguyen.querytypes.user;

import com.davidnguyen.querytypes.address.Address;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

public class UserExample {
    public static Example<User> findUsersByStatusAndCity (String status, String city) {
        User exampleUser = new User();
        exampleUser.setStatus(status);

        Address exampleAddress = new Address();
        exampleAddress.setCity(city);
        exampleUser.setAddress(exampleAddress);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("address.city", ExampleMatcher.GenericPropertyMatchers.exact());

        return Example.of(exampleUser, matcher);
    }
}
