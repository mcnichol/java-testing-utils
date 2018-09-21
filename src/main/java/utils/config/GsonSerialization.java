package utils.config;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GsonSerialization {

    public static final JsonSerializer<Timestamp> timestampSerializer = (src, typeOfSrc, context) -> src == null ? null : new JsonPrimitive(src.getTime());

    public static final JsonDeserializer<Timestamp> timestampDeserializer = (json, typeOfT, context) -> json == null ? null : new Timestamp(json.getAsLong());

    public static final JsonSerializer<LocalDateTime> localDateTimeSerializer = (src, typeOfSrc, context) -> src == null ? null : new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    public static final JsonDeserializer<LocalDateTime> localDateTimeDeserializer = (json, typeOfT, context) -> json == null ? null : LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
}
