package cvc.logic.services;

import com.docmosis.SystemManager;
import com.docmosis.document.DocumentProcessor;
import com.docmosis.template.population.DataProviderBuilder;
import cvc.domain.Cv;
import org.springframework.stereotype.Service;
import com.docmosis.util.Configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PdfService {

    private final String key = "0NAD-KLWO-JALP-MKIA-DBDH-1ELH-VBKQ-HS91-23ED-8-B446";
    private final String site = "Free Trial License";
    private final String officePath = "C:/Program Files/LibreOffice";
    private final Configuration config;

    public PdfService() {
        // TODO add logc for pdf creation.

        if (key.startsWith("XXXX")) {
            System.err.println("\nPlease set your license key");

            throw new InternalError("Docmosis License Invalid on the server.");
        }
        if (!new File(officePath).isDirectory() || !new File(officePath).canRead()) {
            System.err.println("\nPlease check \"officePath\" is set to the " +
                    "install dir for OpenOffice or LibreOffice");
            throw new InternalError("Libre Office not found on the server.");
        }

        // Create the initialisation configuration
        config = new Configuration(key, site, officePath);

        // Tell Docmosis to use one embedded converter
        config.setConverterPoolConfiguration("1");

    }

    public byte[] createPdf(Cv cv) {
        byte[] pdf = null;

        try {

            // Initialise the system based on configuration
            SystemManager.initialise(config);

            // Use the DataProviderBuilder to build the data provider from a String array.
            DataProviderBuilder dpb = new DataProviderBuilder();

            dpb.addJavaObject(cv, "cv");

            File templateFile = new File("cv templates/ResumeTemplate 2.docx");
            File outputFile = new File("temp/cv.pdf");

            if (!templateFile.canRead()) {
                System.err.println("\nCannot find '" + templateFile + "' in: " + new File("").getCanonicalPath());
            } else {

                // Create the document
                DocumentProcessor.renderDoc(templateFile, outputFile, dpb.getDataProvider());

                System.out.println("\nCreated: " + outputFile.getCanonicalPath());
            }


            Path pdfPath = Paths.get("temp/cv.pdf");
            pdf = Files.readAllBytes(pdfPath);
        } catch (Exception e){
            System.err.println("\nPlease check the following: " + e.getMessage());
        } finally {
            // shutdown the system
            SystemManager.release();
        }

        return pdf;
    }
}
