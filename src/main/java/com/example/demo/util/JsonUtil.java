package com.example.demo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

/**
 * @author ziqin.lei
 * @since 2018/5/23
 */
public final class JsonUtil {

    private JsonUtil() {
    }

    private static final Gson DEFAULT_GSON = new GsonBuilder()
            .setLongSerializationPolicy(LongSerializationPolicy.STRING)
            .create();

    public static Gson defaultGson() {
        return DEFAULT_GSON;
    }
}
