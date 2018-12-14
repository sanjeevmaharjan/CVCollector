package cvc.api.controller;

import cvc.domain.CvSearchCriteria;
import cvc.domain.Users;
import cvc.logic.repositories.ICvSearchCriteriaRepository;
import cvc.logic.repositories.IUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserRepository userRepository;
    private ICvSearchCriteriaRepository criteriaRepository;

    public UserController(IUserRepository userRepository, ICvSearchCriteriaRepository criteriaRepository) {
        this.userRepository = userRepository;
        this.criteriaRepository = criteriaRepository;
    }

    @GetMapping("/")
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getSavedCriteria")
    public List<CvSearchCriteria> getSavedCriteria() {
        return this.criteriaRepository.findByUser(1);
    }
}
