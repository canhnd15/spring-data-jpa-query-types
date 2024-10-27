package com.davidnguyen.querytypes;

import com.davidnguyen.querytypes.user.User;
import com.davidnguyen.querytypes.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class QueryTypesApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testDerivedQueryMethods() {
        List<User> usersByFirstNameAndCity = userRepository.findByFirstNameAndAddress_City("John", "Springfield");
        List<User> usersByStatusAndCountry = userRepository.findByStatusAndAddress_Country("ACTIVE", "USA");

        assertEquals(1, usersByFirstNameAndCity.size(), "Expected one user with first name 'John' and city 'Springfield'");
        assertEquals(2, usersByStatusAndCountry.size(), "Expected two users with status ACTIVE and country is USA");
    }

}
