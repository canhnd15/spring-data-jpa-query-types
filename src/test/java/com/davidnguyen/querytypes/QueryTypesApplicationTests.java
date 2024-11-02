package com.davidnguyen.querytypes;

import com.davidnguyen.querytypes.user.UserDTO;
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
    public void testDerivedQueryMethods() {
        List<UserDTO> results =  userRepository.findAllUserInfo()
                .stream()
                .map(UserDTO::of)
                .toList();

        assertEquals(10, results.size(), "Expected 10 users");
    }

}
