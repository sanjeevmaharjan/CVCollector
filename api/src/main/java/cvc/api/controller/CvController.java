package cvc.api.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Bytes;
import cvc.domain.Cv;
import cvc.domain.CvSearchCriteria;
import cvc.domain.Users;
import cvc.logic.CvLogic;
import cvc.logic.repositories.ILinksRepository;
import cvc.logic.services.PdfService;
import cvc.logic.services.interfaces.ICvSearchService;
import cvc.logic.services.interfaces.ICvUpdateService;
import cvc.logic.model.CvSearchCriteriaModel;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cv", produces = MediaType.APPLICATION_JSON_VALUE)
public class CvController {
    private ICvSearchService cvSearchService;
    private ICvUpdateService cvUpdateService;
    private PdfService pdfService;
    private ILinksRepository linksRepository;
    private CvLogic cvLogic;
    private static CachingRecommender cachingRecommender;
    private final int pageSize = 20;

    public CvController(ICvSearchService cvSearchService, ICvUpdateService cvUpdateService, PdfService pdfService, ILinksRepository linksRepository) {
        this.cvSearchService = cvSearchService;
        this.cvUpdateService = cvUpdateService;
        this.pdfService = pdfService;
        this.linksRepository = linksRepository;
    }

    /*
     * forwards to getCvs to smart filter by default
     */
    @GetMapping("/")
    public Page<Cv> index(Pageable page) {

        return getCvs("smart", page);
    }

    /*
     * Gets the list of Cv filtered by filter param
     */
    @GetMapping("/filter/{filter}")
    public Page<Cv> getCvs(@PathVariable String filter, Pageable pageable) {
        Page<Cv> result = this.cvSearchService.findUsersCv(pageable);
        return result;
    }

    /*
     * Gets the cv by id
    */
    @GetMapping("/{id}")
    public Cv getCv(@PathVariable String id) {
        return cvSearchService.getById(Long.parseLong(id));
    }

    /*
     * Inserts the new Cv
     */
    @PostMapping(value = "/add/{id}", consumes = "application/json")
    public void addCv(@PathVariable long id, @RequestBody String payload) {
        // System.out.println(payload);

        try {
            ObjectMapper mapper = new ObjectMapper();
            Cv cv = mapper.readValue(payload, Cv.class);
            cv.setLinks(linksRepository.findById(id).orElse(null));
            System.out.println(cv);
            this.cvUpdateService.save(cv);
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
    }

/*    @GetMapping("/filter/name/{nameStartsWith}")
    public List<Cv> getCvsByName(@PathVariable String nameStartsWith) {
        return cvSearchService.withName(nameStartsWith);
    }*/

    @PostMapping(value = "/filter/criteria", consumes = "application/json")
    public Page<Cv> getCvsByFilterObject(@RequestBody String payload, Pageable pageable) {
        System.out.println(payload);

        CvSearchCriteria filter = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            filter = mapper.readValue(payload, CvSearchCriteria.class);
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

        return this.cvSearchService.findByFilter(new CvSearchCriteriaModel(filter), pageable);
    }

    /*@GetMapping("/getRankedCvs")
    public List<Cv> getRankedCvs(Principal principal) {
        String name = principal.getName();

        List<Users> users = cvSearchService.findUsersCv();
        FastByIDMap<PreferenceArray> preferences = new FastByIDMap<PreferenceArray>();
        for (Users user : users) {
            List<Cv> userCvs = new ArrayList<>();
            PreferenceArray userPreferenceArray = new GenericUserPreferenceArray(userCvs.size());
            userPreferenceArray.setUserID(0, user.getId());
            for (int i = 0; i < userCvs.size(); i++) {
                userPreferenceArray.setItemID(i, userCvs.get(i).getId());
                userPreferenceArray.setValue(i, 1f);
            }
            preferences.put(user.getId(), userPreferenceArray);
        }

        users = null;

        DataModel dataModel = new GenericDataModel(preferences);
        List<Long> ids = new ArrayList<>();

        try {
            List<RecommendedItem> recommendations = recommend(dataModel);
            recommendations.stream().forEach(recommendation -> {
                ids.add(recommendation.getItemID());
            });
            
        }
        catch(TasteException e) {
            e.printStackTrace();
        }

        return cvSearchService.getByIds(ids);
    }*/

    @GetMapping("/getPdf/{id}")
    public ResponseEntity<byte[]> getPdf(@PathVariable String id) {
        Cv cv = this.cvSearchService.getById(Long.parseLong(id));

        byte[] contents = this.pdfService.createPdf(cv);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        // Here you have to set the actual filename of your pdf
        String filename = "Cv-" + id + ".pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);

        return response;
    }

    private static List<RecommendedItem> recommend(DataModel dataModel) throws TasteException {
        if (cachingRecommender != null) {
            return cachingRecommender.recommend(1,2);
        }

        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);

        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, dataModel);

        Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);

        cachingRecommender = new CachingRecommender(recommender);

        return cachingRecommender.recommend(1, 2);
    }
}
