package cvc.logic.seeders;

import cvc.domain.*;
import cvc.logic.repositories.ICvRepository;
import enums.Genders;
import enums.MaritalStatuses;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
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
            List<String> phoneList = new ArrayList<>();
            phoneList.add("1234567890");

            List<String> emailList = new ArrayList<>();
            emailList.add("test@test.com");

            List<Institution> institutionList = new ArrayList<>();
            institutionList.add(
                    new Institution(
                            "Test Institution",
                            "Test Degree",
                            LocalDate.parse("2000-01-01"),
                            LocalDate.parse("2010-01-01"),
                            "Test Institution Summary"
                    )
            );

            List<WorkPlace> workPlaceList = new ArrayList<>();
            workPlaceList.add(
                    new WorkPlace(
                            "Test Name",
                            "Tester",
                            LocalDate.parse("2000-01-01"),
                            LocalDate.parse("2010-01-01"),
                            "Test WorkPlace Summary"
                    )
            );

            List<Project> projectList = new ArrayList<>();
            projectList.add(
                    new Project(
                            "Test Project",
                            "Test Organizer",
                            LocalDate.parse("2000-01-01"),
                            LocalDate.parse("2010-01-01"),
                            "Test Summary"
                    )
            );

            List<LanguageProficiency> languageProficiencyList = new ArrayList<>();
            languageProficiencyList.add(
                    new LanguageProficiency(
                            "Nepali",
                            "Reading and Writing"
                    )
            );
            languageProficiencyList.add(
                    new LanguageProficiency(
                            "English",
                            "Reading and Writing"
                    )
            );

            List<Award> awardList = new ArrayList<>();
            awardList.add(
                    new Award(
                            "Best Actor Award",
                            (short)2018,
                            "Acting"
                    )
            );

            Cv cv = new Cv(
                    new PersonalDetails(
                            "TestFirstName",
                            "TestLastName",
                            Genders.Male,
                            LocalDate.parse("1994-11-22"),
                            "Daddy",
                            "Mommy",
                            "Nepali",
                            MaritalStatuses.Unmarried,
                            "Tester",
                            "Just a test Cv"
                    ),
                    new ContactDetails(
                            phoneList,
                            emailList,
                            "TestCountry",
                            "TestState",
                            "TestCity",
                            false,
                            44600,
                            "fb.me/maharjanx",
                            "Test Additional Details"
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
                    ),
                    new AdditionalInfo(
                            languageProficiencyList,
                            "Singing, Dancing",
                            "Test Notes."
                    ),
                    awardList
            );

            cvs.add(cv);
        }

        cvRepository.saveAll(cvs);
    }
}
