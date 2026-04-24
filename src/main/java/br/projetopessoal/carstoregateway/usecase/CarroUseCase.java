package br.projetopessoal.carstoregateway.usecase;

import br.projetopessoal.carstoregateway.model.Carro;
import br.projetopessoal.carstoregateway.repository.CarroRepository;
import br.projetopessoal.carstoregateway.utils.JsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class CarroUseCase {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    public Carro execute(Carro carro) throws JsonProcessingException {
        validar(carro);
        return salvar(carro);
    }

    private void validar(Carro carro) throws JsonProcessingException {
        Document schemaDoc = mongoTemplate.getCollection("validation_schema")
                .find(new Document("entity", "Carro"))
                .first();

        Document schemaField = (Document) schemaDoc.get("fields");
        JSONObject schemaJson = new JSONObject(schemaField.toJson());
        Schema schema = SchemaLoader.load(schemaJson);
        JSONObject carroJson = new JSONObject(mapper.writeValueAsString(carro));
        schema.validate(carroJson);
    }

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }


}
