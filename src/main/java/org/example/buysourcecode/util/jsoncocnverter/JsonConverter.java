package org.example.buysourcecode.util.jsoncocnverter;

import org.springframework.stereotype.Component;

@Component
public interface JsonConverter {
    String toJson(Object obj);
    <T> T fromJson(String json, Class<T> clazz);
}
