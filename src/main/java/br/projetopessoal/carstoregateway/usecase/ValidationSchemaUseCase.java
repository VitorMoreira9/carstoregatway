package br.projetopessoal.carstoregateway.usecase;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ValidationSchemaUseCase {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Document getSchema(String entity) {
        return mongoTemplate.getCollection("validation_schema")
                .find(new Document("entity", entity))
                .first();
    }
}
