package test;

import com.github.javafaker.Faker;


public class TestDataUi {
    Faker faker = new Faker();

    public String
            email = faker.internet().emailAddress(),
            name = faker.name().fullName(),
            nameProjectUi = faker.funnyName().name(),
            announcementProjectUi = faker.harryPotter().character(),
            nameRunsUi = faker.harryPotter().location(),
            newAnnouncementProjectUi = faker.harryPotter().character();


}
