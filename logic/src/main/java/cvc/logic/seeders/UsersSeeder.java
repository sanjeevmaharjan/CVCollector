package cvc.logic.seeders;

import cvc.domain.Roles;
import cvc.domain.Users;
import cvc.logic.repositories.IRoleRepository;
import cvc.logic.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersSeeder implements CommandLineRunner {
    private IUserRepository userRepository;
    private IRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UsersSeeder(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0)
            return;

        Roles adminRole = new Roles("ROLE_ADMIN");
        Roles clientRole = new Roles("ROLE_CLIENT");
        Roles userRole = new Roles("ROLE_USER");

        List<Roles> roles = new ArrayList<>();
        roles.add(adminRole);
        roles.add(clientRole);
        roles.add(userRole);

        roleRepository.saveAll(roles);


        String password = encoder.encode("Admin");
        Users sanjeev = new Users("Sanjeev Maharjan", "sanjeev", password, roles);
        Users prazeen = new Users("Prazeen Shrestha", "prazeen",password, roles);
        Users prakash = new Users("Prakash Aryal", "prakash",password, roles);

        List<Users> usersList = new ArrayList<>();

        usersList.add(sanjeev);
        usersList.add(prazeen);
        usersList.add(prakash);

        userRepository.saveAll(usersList);
    }
}
