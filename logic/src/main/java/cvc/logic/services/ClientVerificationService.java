package cvc.logic.services;

import cvc.domain.Roles;
import cvc.domain.Users;
import cvc.logic.repositories.IUserRepository;
import cvc.logic.specifications.UserSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientVerificationService implements UserDetailsService {
    private final IUserRepository userRepository;

    public ClientVerificationService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid Username or Password.");
        }

        return new User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private List<GrantedAuthority> getAuthority(Users user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Roles role: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public List<Users> findAll() {
        List<Users> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Users getByUsername(String username) {
        Specification<Users> specs = UserSpecifications.thisUsername(username);
        return userRepository.findOne(specs).orElse(null);
    }
}
