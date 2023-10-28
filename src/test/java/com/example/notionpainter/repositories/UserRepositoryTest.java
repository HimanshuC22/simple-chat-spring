package com.example.notionpainter.repositories;

import com.example.notionpainter.TestHelper;
import com.example.notionpainter.models.Password;
import com.example.notionpainter.models.User;
import com.example.notionpainter.repositories.PasswordRepository;
import com.example.notionpainter.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordRepository paswordRepository;

    private User user;
    private Password password;

    @BeforeEach
    public void setup() {
        password = Password.builder()
                .hash("password1")
                .salt("salt1")
                .build();
        user = User.builder()
                .firstName("FirstName1")
                .lastName("LastName1")
                .email("user1@example.com")
                .password(password)
                .build();
    }

    @Test
    @DisplayName("Create Entities")
    public void createUser() {
        Password savedPassword = paswordRepository.save(password);
        User savedUser = userRepository.save(user);

        Assertions.assertNotNull(savedUser);
        Assertions.assertNotNull(savedPassword);
        Assertions.assertEquals(savedUser.getPassword().getHash(), savedPassword.getHash());
        Assertions.assertEquals(savedUser.getFirstName(), user.getFirstName());
        Assertions.assertEquals(savedPassword.getHash(), password.getHash());
        TestHelper.printObject(savedUser);
        TestHelper.printObject(savedPassword);
    }

    @Test
    @DisplayName("Update Entities")
    public void updateUser() {
        Password savedPassword = paswordRepository.save(password);
        User savedUser = userRepository.save(user);

        Assertions.assertNotNull(savedUser);
        Assertions.assertNotNull(savedPassword);

        savedUser.setFirstName("ChangedFirstName1");
        savedUser.setEmail("changedemail1@example.com");
        user = userRepository.save(savedUser);
        Assertions.assertEquals(savedUser.getPassword().getHash(), savedPassword.getHash());
        Assertions.assertEquals(savedUser.getFirstName(), user.getFirstName());
        Assertions.assertEquals(savedPassword.getHash(), password.getHash());
        TestHelper.printObject(savedUser);
    }

    @AfterEach
    public void teardown() {
        userRepository.deleteAll();
        paswordRepository.deleteAll();
    }
}
