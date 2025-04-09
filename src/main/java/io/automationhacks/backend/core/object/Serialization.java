package io.automationhacks.backend.core.object;

import com.google.gson.Gson;

public class Serialization {
    // serialize and deserialize using gson
    public static String serialize(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T deserialize(String json, Class<T> classOfT) {
        return new Gson().fromJson(json, classOfT);
    }
}
