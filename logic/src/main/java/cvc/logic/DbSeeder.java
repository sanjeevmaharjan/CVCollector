package cvc.logic;

import cvc.domain.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private IUserRepository userRepository;

    public DbSeeder(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0)
            return;
        Users sanjeev = new Users("Sanjeev Maharjan", "sanjeev", "password");
        Users prazeen = new Users("Prazeen Shrestha", "prazeen","2018");
        Users prakash = new Users("Prakash Aryal", "prakash","prakash111");

        List<Users> usersList = new ArrayList<>();

        usersList.add(sanjeev);
        usersList.add(prazeen);
        usersList.add(prakash);

        userRepository.saveAll(usersList);
    }
}
