package cvc.api.controller;

import client.entities.Dashboard;
import cvc.logic.services.interfaces.ICvSearchService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardController {
    private ICvSearchService cvSearchService;

    public DashboardController(ICvSearchService cvSearchService) {
        this.cvSearchService = cvSearchService;
    }

    @GetMapping("")
    public Dashboard index() {
        return this.cvSearchService.getDashboardStats();
    }
}
