package br.projetopessoal.carstoregateway.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class JsonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JSONObject toJson(Object obj) {
        try {
            String jsonString = mapper.writeValueAsString(obj);
            return new JSONObject(jsonString);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter para JSON", e);
        }
    }
}
