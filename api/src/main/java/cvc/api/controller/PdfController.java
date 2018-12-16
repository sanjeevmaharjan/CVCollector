package cvc.api.controller;

import cvc.domain.Cv;
import cvc.logic.services.PdfService;
import cvc.logic.services.interfaces.ICvSearchService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/getPdf", produces = MediaType.APPLICATION_PDF_VALUE)
public class PdfController {

    private ICvSearchService cvSearchService;
    private PdfService pdfService;

    public PdfController(ICvSearchService cvSearchService, PdfService pdfService) {
        this.cvSearchService = cvSearchService;
        this.pdfService = pdfService;
    }

    @GetMapping("/{id}")
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
}
