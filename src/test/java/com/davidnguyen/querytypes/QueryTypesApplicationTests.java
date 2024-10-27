package com.davidnguyen.querytypes;

import com.davidnguyen.querytypes.user.User;
import com.davidnguyen.querytypes.user.UserRepository;
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
    void testCriteriaQuery() {
        List<User> usersByStatus = userRepository.findUsersByStatusAndCity("ACTIVE", "NewYork");

        assertEquals(1, usersByStatus.size(), "Expected 1 user with status ACTIVE and city is NewYork");
    }

}
