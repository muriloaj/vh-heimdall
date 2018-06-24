package com.github.muriloaj.vkheimdall.commons;

import java.util.Set;
import java.util.stream.Stream;

public enum EndpointURI {
    ROOT("/"),
    ISSUE("/issue/:reference"),
    VALIDATE("/validate"),
    REVOGATE("/revogate/:token");

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
