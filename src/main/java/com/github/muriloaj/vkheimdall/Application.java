package com.github.muriloaj.vkheimdall;

import com.github.muriloaj.vkheimdall.commons.EndpointURI;
import com.github.muriloaj.vkheimdall.controller.TokenController;

import static com.github.muriloaj.vkheimdall.commons.JsonUtils.json;
import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {

        configAPI();

        path("token", () -> {

                    get(EndpointURI.ROOT.getValue(), (req, res) -> EndpointURI.values(), json());

                    post(EndpointURI.ISSUE.getValue(), (req, res) -> TokenController.issue(req, res), json());

                    post(EndpointURI.VALIDATE.getValue(), (req, res) -> TokenController.validate(req, res), json());

                    post(EndpointURI.REVOGATE.getValue(), (req, res) -> TokenController.revogate(req, res), json());
                }
        );


    }

    private static void configAPI() {
        int maxThreads = 10;
        int minThreads = 2;
        int timeOutMillis = 3000;
        threadPool(maxThreads, minThreads, timeOutMillis);
        port(8881);
    }
}


