package org.example.buysourcecode.util.jsoncocnverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import static java.lang.reflect.Modifier.TRANSIENT;

@Component
public class JsonConverterImpl implements JsonConverter {

    private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .excludeFieldsWithModifiers(TRANSIENT).create();

    @Override
    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
