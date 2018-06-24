package com.github.muriloaj.vkheimdall.commons;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonUtils {

    private static String toJson(Object object) {
        System.out.println(new Gson().toJson(object));
        return new Gson().toJson(object);
    }

    public static Object fromJson(String json, Class classs) {
        return new Gson().fromJson(json, classs);
    }

    public static ResponseTransformer json() {
        return JsonUtils::toJson;
    }


}
