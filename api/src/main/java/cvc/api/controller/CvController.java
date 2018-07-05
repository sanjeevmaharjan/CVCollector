package cvc.api.controller;

import cvc.domain.Cv;
import cvc.logic.ICvRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cv", produces = MediaType.APPLICATION_JSON_VALUE)
public class CvController {
    private ICvRepository cvRepository;

    public CvController(ICvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @GetMapping("/")
    public List<Cv> index() {
        return getCv("smart");
    }

    @GetMapping("/filter/{filter}")
    public List<Cv> getCv(@PathVariable String filter) {
        return this.cvRepository.findAll();
    }

    @PostMapping(value = "/post", consumes = "application/json")
    public void addCv(@RequestBody Cv cv) {
        this.cvRepository.save(cv);
    }
}
