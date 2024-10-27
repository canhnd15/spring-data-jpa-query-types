package com.davidnguyen.querytypes;

import com.davidnguyen.querytypes.user.User;
import com.davidnguyen.querytypes.user.UserRepository;
import com.davidnguyen.querytypes.user.UserSpec;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class QueryTypesApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testSpecificationAPI() {
        List<User> usersByStatusAndCity = userRepository.findAll(Specification.where(UserSpec.hasStatus("ACTIVE")).and(UserSpec.hasCity("NewYork")));

        assertEquals(1, usersByStatusAndCity.size(), "Expected one user with status ACTIVE and city is NewYork");
    }

}
