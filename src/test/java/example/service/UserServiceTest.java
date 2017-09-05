package example.service;

import example.config.ApplicationContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void queryUserName() throws Exception {
        System.out.println(userService.queryUserName(2));
    }

    @Test
    public void queryUser() throws Exception {
        System.out.println(userService.queryUser("C"));
    }

}