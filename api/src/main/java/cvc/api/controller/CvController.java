package cvc.api.controller;

import cvc.domain.Cv;
import cvc.logic.CvLogic;
import cvc.logic.interfaces.ICvRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cv", produces = MediaType.APPLICATION_JSON_VALUE)
public class CvController {
    private ICvRepository cvRepository;
    private CvLogic cvLogic;

    public CvController(ICvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    /*
     * forwards to getCvs to smart filter by default
     */
    @GetMapping("/")
    public List<Cv> index() {
        return getCvs("smart");
    }

    /*
     * Gets the list of Cv filtered by filter param
     */
    @GetMapping("/filter/{filter}")
    public List<Cv> getCvs(@PathVariable String filter) {
        return this.cvRepository.findAll();
    }

    /*
     * Gets the cv by id
    */
    @GetMapping("/{id}")
    public Cv getCv(@PathVariable String id) {
        return cvRepository.getOne(Long.parseLong(id));
    }

    /*
     * Inserts the new Cv
     */
    @PostMapping(value = "/post", consumes = "application/json")
    public void addCv(@RequestBody Cv cv) {
        this.cvRepository.save(cv);
    }
}
