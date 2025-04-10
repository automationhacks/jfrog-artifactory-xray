package io.automationhacks.backend.core.object;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class Serialization {
    public static String serialize(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T deserialize(String json, Class<T> classOfT) {
        return new Gson().fromJson(json, classOfT);
    }

    public static <T> T deserialize(String json, Type type) {
        return new Gson().fromJson(json, type);
    }
}
