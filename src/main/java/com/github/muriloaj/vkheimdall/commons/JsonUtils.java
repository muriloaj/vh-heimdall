package com.github.muriloaj.vkheimdall.commons;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonUtils {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static Object fromJson(String json, Class classs) {
        return new Gson().fromJson(json, classs);
    }

    public static ResponseTransformer json() {
        return JsonUtils::toJson;
    }


}
