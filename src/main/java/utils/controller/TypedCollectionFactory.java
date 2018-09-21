package utils.controller;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class TypedCollectionFactory<T> {
    private final Gson gsonMapper;

    public TypedCollectionFactory(final Gson gsonMapper) {
        this.gsonMapper = gsonMapper;
    }

    public Map<String, T> deserializeMap(final String json, final Class<T> clazz) {

        return gsonMapper.fromJson(json, new ParameterizedMapWrapper<>(clazz));
    }

    public List<T> deserializeList(final String json, final Class<T> clazz) {
        return gsonMapper.fromJson(json, new ParameterizedListWrapper<>(clazz));
    }
}
