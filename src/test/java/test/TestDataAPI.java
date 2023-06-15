package test;

import com.github.javafaker.Faker;


public class TestDataAPI {
    Faker faker = new Faker();

    public String nameSuite = faker.gameOfThrones().house(),
            stepContent = faker.gameOfThrones().dragon(),
            stepExpected = faker.gameOfThrones().city(),
            stepTitle = faker.gameOfThrones().quote(),
            nameDescription = faker.gameOfThrones().dragon(),
            nameProjectApi = faker.gameOfThrones().dragon(),
            announcementProjectApi = faker.gameOfThrones().character();


    public Integer sectionId = 2,
            projectId = 6,
            suiteId = 3;
}
