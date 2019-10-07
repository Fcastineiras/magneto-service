package com.challenge.magneto.service.repository;

import com.challenge.magneto.service.model.dto.Data;
import com.google.common.annotations.VisibleForTesting;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class GenericQueries {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoDatabase mongoDatabase;

    public boolean post(Data data) {
        try {
            Document dnaDocument = new Document();
            dnaDocument.put(data.getClass().getName(), data);
            mongoDatabase.getCollection(data.getClass().getName()).insertOne(dnaDocument);
            log.info("success save:" + data.getClass().getName());
            return true;
        } catch (MongoException | ClassCastException e) {
            log.error(e.getMessage());
            return false;
        }
    }


    public ArrayList<Data> getAll(Data data) {
        ArrayList<Data> dataArrayList =  new ArrayList<Data>();
        try {
            FindIterable<Document> docs = mongoDatabase.getCollection(data.getClass().getName()).find();
            for (Document doc : docs) {
                dataArrayList.add(doc.get(data.getClass().getName(), Data.class));
            }
            return dataArrayList;
        } catch (MongoException | ClassCastException e) {
            log.error( e.getMessage());
            return new ArrayList<Data>();
        }
    }

    @VisibleForTesting
    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }
}
