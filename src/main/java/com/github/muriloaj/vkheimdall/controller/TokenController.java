package com.github.muriloaj.vkheimdall.controller;

import com.github.muriloaj.vkheimdall.model.Token;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.UUID;

import static com.github.muriloaj.vkheimdall.commons.JsonUtils.fromJson;
import static com.github.muriloaj.vkheimdall.commons.JsonUtils.toJson;


public class TokenController {

    public static Route issue = (Request req, Response resp) -> {
        try {

            String reference = req.params("reference");
            return new Token(UUID.randomUUID().toString(), reference, true);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            resp.status(501);
            return toJson(e.getMessage());
        }

    };

    public static Route validate = (Request req, Response resp) -> {
        try {

            Token token = (Token) fromJson(req.body(), Token.class);
            token.setValidated(true);
            return token;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return toJson(e.getMessage());
        }
    };

    public static Route revoke = (Request req, Response resp) -> { try {

        String token = req.params("token");
        return new Token(token, "", false);

    } catch (Exception e) {
        System.err.println(e.getMessage());
        resp.status(501);
        return toJson(e.getMessage());
    }
    };
}
