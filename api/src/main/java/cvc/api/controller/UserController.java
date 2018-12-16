package cvc.api.controller;

import cvc.domain.Cv;
import cvc.domain.CvSearchCriteria;
import cvc.domain.Links;
import cvc.domain.Users;
import cvc.logic.repositories.ICvSearchCriteriaRepository;
import cvc.logic.repositories.ILinksRepository;
import cvc.logic.repositories.IUserRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private IUserRepository userRepository;
    private ICvSearchCriteriaRepository criteriaRepository;
    private ILinksRepository linksRepository;

    public UserController(IUserRepository userRepository, ICvSearchCriteriaRepository criteriaRepository, ILinksRepository linksRepository) {
        this.userRepository = userRepository;
        this.criteriaRepository = criteriaRepository;
        this.linksRepository = linksRepository;
    }

    @GetMapping("/")
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getLinks")
    public List<Links> getLinks(Principal principal) {
        return linksRepository.findByUser(principal.getName());
    }

    public void addLinks(Principal principal) {
        Links link = new Links();
        Users user = userRepository.findByUsername(principal.getName()).orElse(null);
        link.setUser(user);
        return linksRepository.save(link);
    }

    @GetMapping("/getLinksCv/{id}")
    public List<Cv> getLinksCv(@PathVariable Long id, Principal principal) {
        Links link = this.linksRepository.findById(id).orElse(null);
        if (link == null || !link.getUser().getUsername().equals(principal.getName())) {
            return null;
        }

        return link.getCvs();
    }

    @GetMapping("/getSavedCriteria")
    public List<CvSearchCriteria> getSavedCriteria() {
        return this.criteriaRepository.findByUser(1);
    }
}
