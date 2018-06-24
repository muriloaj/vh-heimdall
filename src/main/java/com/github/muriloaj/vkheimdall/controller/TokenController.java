package com.github.muriloaj.vkheimdall.controller;

import com.github.muriloaj.vkheimdall.model.Token;
import spark.Request;
import spark.Response;

import java.util.UUID;

import static com.github.muriloaj.vkheimdall.commons.JsonUtils.fromJson;
import static com.github.muriloaj.vkheimdall.service.RedisConnector.useJedis;
import static spark.utils.StringUtils.isNotEmpty;


public class TokenController {

    public static Token issue(Request req, Response res) {

        try {
            String reference = req.params("ref");
            System.out.println("--".concat(reference));
            String uuid = UUID.randomUUID().toString();
            useJedis().set(uuid, reference);
            System.out.println(uuid);
            return new Token(uuid, reference, true);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            res.status(501);

            return null;
        }

    }

    public static Token validate(Request req, Response res) {
        try {

            Token token = (Token) fromJson(req.body(), Token.class);
            String reference = useJedis().get(token.getToken());
            return new Token(token.getToken(), reference, isNotEmpty(reference));


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            res.status(501);

            return null;
        }
    }

    public static Token revogate(Request req, Response res) {
        try {

            Token token = (Token) fromJson(req.body(), Token.class);
            useJedis().del(token.getToken());

            return validate(req, res);


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            res.status(501);

            return null;
        }
    }
}

