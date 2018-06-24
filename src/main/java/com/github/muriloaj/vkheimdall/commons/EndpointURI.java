package com.github.muriloaj.vkheimdall.commons;

import java.util.stream.Stream;

public enum EndpointURI {

    ROOT("/"),
    ISSUE("/issue/:ref"),
    VALIDATE("/validate"),
    REVOGATE("/revogate");

    private String uri;

    EndpointURI(String uri) {
        this.uri = uri;
    }

    public String getValue() {
        return this.uri;
    }

    public static Stream<EndpointURI> stream() {
        return Stream.of(EndpointURI.values());
    }

}
