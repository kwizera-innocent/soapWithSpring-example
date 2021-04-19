package rw.kwizera.springsoapexample.service;

import org.springframework.stereotype.Service;
import rw.kwizera.springsoapexample.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Map<String, User> users = new HashMap<>();
    @PostConstruct
    public  void initialize(){
        User user = new User();
        user.setEmpId(1);
        user.setName("kwizera");
        user.setSalary(200.1);
        User user1 = new User();
        user1.setEmpId(2);
        user1.setName("innocent");
        user1.setSalary(300);
        users.put(user.getName(), user);
        users.put(user1.getName(), user1);
    }

    public  User getUsers(String name) {
        return users.get(name);
    }
}
