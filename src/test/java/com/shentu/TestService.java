/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/6/7
 * Time: 18:04
 * Describe:
 */

package com.shentu;

import com.shentu.entity.User;
import com.shentu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestService {
    @Autowired
    private UserService userService;

    @Test
    public void getAll(){
        List<User> users = userService.list();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
