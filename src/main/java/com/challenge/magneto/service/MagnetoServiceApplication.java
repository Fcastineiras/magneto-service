package com.challenge.magneto.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MagnetoServiceApplication {

	@Value("${mongodb.host}")
	private String mongoURL;

	@Value("${mongodb.dbname}")
	private String mongoDBName;

	@Value("${required.repeated.char}")
	private int repeatedChar;

	public static void main(String[] args) {
		SpringApplication.run(MagnetoServiceApplication.class, args);
	}

	@Bean
	public MongoDatabase mongoDatabase(){
		 MongoClient mongoClient = MongoClients.create(mongoURL);
		 return mongoClient.getDatabase(mongoDBName);
	}


}
