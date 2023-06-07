package com.example.spring_security.start;
import com.example.spring_security.models.Role;
import com.example.spring_security.models.User;
import com.example.spring_security.service.RoleServiceImpl;
import com.example.spring_security.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class OnStart {
    private final UserService userService;
    private final RoleServiceImpl roleService;

    public OnStart(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        Set<Role> adminRole = new HashSet<>();
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");

        adminRole.add(roleAdmin);
        adminRole.add(roleUser);

        Set<Role> userRole = new HashSet<>();
        userRole.add(roleUser);

        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);

        User admin = new User("admin", "admin", 35, "a@mail.ru", "admin", adminRole);
        User user = new User("user", "user", 36, "u@mail.ru", "user", userRole);

        userService.add(admin);
        userService.add(user);

    }
}
