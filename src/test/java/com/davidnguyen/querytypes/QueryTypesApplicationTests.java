package com.davidnguyen.querytypes;

import com.davidnguyen.querytypes.user.UserProjectionDTO;
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
        List<UserProjectionDTO> users = userRepository.findAllUserInfo();

        assertEquals(10, users.size(), "Expected 10 users");
    }

}
