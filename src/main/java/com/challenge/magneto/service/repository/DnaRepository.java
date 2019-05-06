package com.challenge.magneto.service.repository;

import com.challenge.magneto.service.model.Dna;
import com.google.common.annotations.VisibleForTesting;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Fiamma on 5/5/2019.
 */
@Repository
public class DnaRepository {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoDatabase mongoDatabase;

    @Value("${mongodb.collection.name}")
    private String mongoCollectionName;

    public boolean saveDna(Dna dna) {
        try {
        Document dnaDocument = new Document();
        dnaDocument.put("dna", dna.getDna());
        dnaDocument.put("isMutant", dna.isMutant());
        mongoDatabase.getCollection(mongoCollectionName).insertOne(dnaDocument);
        log.info( "success save dna");
        return true;
        } catch (MongoException | ClassCastException e) {
            log.error( e.getMessage());
            return false;
        }
    }

    public ArrayList<Boolean> fetchAllIsMutantDna() {
        ArrayList<Boolean> isMutantList =  new ArrayList<Boolean>();
        try {
            FindIterable<Document> docs =mongoDatabase.getCollection(mongoCollectionName).find();
            for (Document doc : docs) {
                isMutantList.add(doc.get("isMutant",Boolean.class));
                }
                return isMutantList;
        } catch (MongoException | ClassCastException e) {
            log.error( e.getMessage());
            return new ArrayList<Boolean>();
        }
    }

    @VisibleForTesting
    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }
}
