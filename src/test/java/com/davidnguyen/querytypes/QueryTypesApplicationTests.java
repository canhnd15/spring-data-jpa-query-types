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
    void testNativeQueries() {
        List<User> usersByStatus = userRepository.findUsersByStatus("ACTIVE");

        assertEquals(2, usersByStatus.size(), "Expected two users with status ACTIVE");
    }

}
