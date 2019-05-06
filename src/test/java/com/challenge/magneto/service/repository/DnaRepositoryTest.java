package com.challenge.magneto.service.repository;

import com.challenge.magneto.service.mocks.DnaDtoMocks;
import com.challenge.magneto.service.model.Dna;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.UnknownHostException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Fiamma on 5/5/2019.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DnaRepositoryTest {

    @Autowired
    private DnaRepository dnaRepository;

    @Autowired
    private MongoDatabase mongoDatabase;

    @Test
    public void saveDnaDBConnection() {
        dnaRepository.setMongoDatabase(mongoDatabase);
        boolean isSuccess = dnaRepository.saveDna(new Dna(new ArrayList<>(), false));
        assertTrue(isSuccess);
    }

    @Test
    public void failSaveDnaDB() {
        MongoClient mongoClient = MongoClients.create("mongodb://fail");
        dnaRepository.setMongoDatabase(mongoClient.getDatabase("fail"));
        boolean isSuccess = dnaRepository.saveDna(new Dna(new ArrayList<>(), false));
        assertFalse(isSuccess);
    }


}
