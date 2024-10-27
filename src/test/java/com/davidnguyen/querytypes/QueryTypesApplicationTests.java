package com.davidnguyen.querytypes;

import com.davidnguyen.querytypes.user.User;
import com.davidnguyen.querytypes.user.UserExample;
import com.davidnguyen.querytypes.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class QueryTypesApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testQueryByExample() {
        Example<User> example = UserExample.findUsersByStatusAndCity("ACTIVE", "NewYork");

        List<User> usersByExample = userRepository.findAll(example);

        assertEquals(1, usersByExample.size(), "Expected one user with status ACTIVE and city is NewYork");
    }

}
