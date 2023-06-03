package test;

import com.github.javafaker.Faker;


public class TestDataAPI {
    Faker faker = new Faker();

    public String nameSuite = faker.rickAndMorty().quote(),
            stepContent = faker.rickAndMorty().quote(),
            stepExpected = faker.rickAndMorty().quote(),
            stepTitle = faker.rickAndMorty().quote(),
            nameDescription= faker.rickAndMorty().quote();

    public Integer   sectionId = 1,
            projectId = 17,
            suiteId = 12;
}
