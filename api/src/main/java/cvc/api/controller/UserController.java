package cvc.api.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cvc.domain.Cv;
import cvc.domain.CvSearchCriteria;
import cvc.domain.Links;
import cvc.domain.Users;
import cvc.logic.repositories.ICvSearchCriteriaRepository;
import cvc.logic.repositories.ILinksRepository;
import cvc.logic.repositories.IUserRepository;
import cvc.logic.services.interfaces.ICvSearchService;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private IUserRepository userRepository;
    private ICvSearchCriteriaRepository criteriaRepository;
    private ILinksRepository linksRepository;
    private ICvSearchService cvSearchService;

    public UserController(IUserRepository userRepository, ICvSearchCriteriaRepository criteriaRepository, ILinksRepository linksRepository, ICvSearchService cvSearchService) {
        this.userRepository = userRepository;
        this.criteriaRepository = criteriaRepository;
        this.linksRepository = linksRepository;
        this.cvSearchService = cvSearchService;
    }

    @GetMapping("/")
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getLinks")
    public List<Links> getLinks(Principal principal) {
        return linksRepository.findByUser(principal.getName());
    }

    @PostMapping("/addLink")
    public long addLinks(@RequestBody String payload, Principal principal) {
        // System.out.println(payload);

        long id = 0;

        try {
            ObjectMapper mapper = new ObjectMapper();
            Links link = mapper.readValue(payload, Links.class);
            Users user = userRepository.byUsername(principal.getName()).orElse(null);

            if (user != null) {
                user.getLinks().add(link);
                link.setUser(user);
            }
            Links newLink = this.linksRepository.save(link);

            id = newLink.getId();

        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    @GetMapping("/getLinksCv/{id}")
    public Page<Cv> getLinksCv(@PathVariable Long id, Pageable pageable, Principal principal) {
        Links link = this.linksRepository.findById(id).orElse(null);
        if (link == null || !link.getUser().getUsername().equals(principal.getName())) {
            return null;
        }

        return this.cvSearchService.findByLink(id, pageable);
    }

    @GetMapping("/getSavedCriteria")
    public List<CvSearchCriteria> getSavedCriteria() {
        return this.criteriaRepository.findByUser(1);
    }
}
