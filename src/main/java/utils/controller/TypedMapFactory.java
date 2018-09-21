package utils.controller;

import com.google.gson.Gson;

import java.util.Map;

public class TypedMapFactory<T> {
    public Map<String, T> deserialize(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, new ParameterizedMap<>(clazz));
    }
}
