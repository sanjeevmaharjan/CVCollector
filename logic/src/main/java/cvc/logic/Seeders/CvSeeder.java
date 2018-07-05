package cvc.logic.Seeders;

import cvc.domain.*;
import cvc.logic.ICvRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class CvSeeder implements CommandLineRunner {
    private ICvRepository cvRepository;

    public CvSeeder(ICvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public void run(String... args) {
        if (cvRepository.count() > 0) {
            return;
        }

        List<Cv> cvs = new ArrayList<>();

        for (int i = 0; i < 10; i ++) {
            List<Institution> institutionList = new ArrayList<>();
            institutionList.add(
                    new Institution(
                            "Test Institution",
                            "Test Degree",
                            new GregorianCalendar(2000,1,1).getTime(),
                            new GregorianCalendar(2010, 1, 1).getTime(),
                            "Test Institution Summary"
                    )
            );

            List<WorkPlace> workPlaceList = new ArrayList<>();
            workPlaceList.add(
                    new WorkPlace(
                            "Test Name",
                            "Tester",
                            new GregorianCalendar(2000,1,1).getTime(),
                            new GregorianCalendar(2010, 1, 1).getTime(),
                            "Test WorkPlace Summary"
                    )
            );

            List<Project> projectList = new ArrayList<>();
            projectList.add(
                    new Project(
                            "Test Project",
                            "Test Organizer",
                            new GregorianCalendar(2000,1,1).getTime(),
                            new GregorianCalendar(2010, 1, 1).getTime(),
                            "Test Summary"
                    )
            );

            Cv cv = new Cv(
                    new PersonalDetails(
                            "TestFirstName TestLastName",
                            new GregorianCalendar(1994, 11, 22).getTime(),
                            "Daddy",
                            "Mommy",
                            "Nepali",
                            "Single",
                            "Tester",
                            "Just a test Cv"
                    ),
                    new ContactDetails(
                            "1234567890",
                            "test@test.com",
                            "TestCountry",
                            "TestState",
                            "TestCity",
                            "TestStreet"
                    ),
                    new EducationDetails(
                            institutionList,
                            "Test Education Details"
                    ),
                    new ProfessionalDetails(
                            "Test Skill 1, Test Skill 2",
                            workPlaceList,
                            "Test Professional Details Summary"
                    ),
                    new ProjectDetails(
                            projectList,
                            "Test Project Summary"
                    )
            );

            cvs.add(cv);
        }

        cvRepository.saveAll(cvs);
    }
}
