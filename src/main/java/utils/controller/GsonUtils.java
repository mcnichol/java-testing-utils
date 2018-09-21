package utils.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.config.GsonSerialization;

import java.util.List;
import java.util.Map;

public class GsonUtils {
    private static final Gson gsonMapper = new GsonBuilder()
            .registerTypeAdapter(java.sql.Timestamp.class, GsonSerialization.timestampDeserializer)
            .registerTypeAdapter(java.sql.Timestamp.class, GsonSerialization.timestampSerializer)
            .registerTypeAdapter(java.time.LocalDateTime.class, GsonSerialization.localDateTimeDeserializer)
            .registerTypeAdapter(java.time.LocalDateTime.class, GsonSerialization.localDateTimeSerializer)
            .create();

    public static <T> T convertJsonStringResponseToObject(final String actualResponse, final Class<T> clazz) {
        return gsonMapper.fromJson(actualResponse, clazz);
    }

    public static <T> String convertObjectToJsonString(final T object) {
        return gsonMapper.toJson(object);
    }

    public static <T> Map<String, T> convertStringResponseToTypedMap(final String actualResponse, final Class<T> clazz) {
        return new TypedCollectionFactory<T>(gsonMapper).deserializeMap(actualResponse, clazz);
    }

    public static <T> List<T> convertStringResponseToTypedList(final String actualResponse, final Class<T> clazz) {
        return new TypedCollectionFactory<T>(gsonMapper).deserializeList(actualResponse, clazz);
    }
}
