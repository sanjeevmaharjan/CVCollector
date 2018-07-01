package cvc.logic;

import cvc.domain.User;
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
        User sanjeev = new User("Sanjeev Maharjan", "dgheet1z");
        User prazeen = new User("Prazeen Shrestha", "2018");
        User prakash = new User("Prakash Aryal", "prakash111");

        List<User> usersList = new ArrayList<>();

        usersList.add(sanjeev);
        usersList.add(prazeen);
        usersList.add(prakash);

        userRepository.saveAll(usersList);
    }
}
