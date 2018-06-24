package com.github.muriloaj.vkheimdall.model;

public class Token {

    private String reference;
    private String token;
    private Boolean validated;

    public Token(String token, Boolean validated) {
        this();
        this.token = token;
        this.validated = validated;
    }

    public Token(String token, String reference, Boolean validated) {
        this.reference = reference;
        this.token = token;
        this.validated = validated;
    }

    public Token() {
        this.reference = "";
        this.token = "";
        this.validated = null;
    }

    public Boolean getValidated() {
        return this.validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getReferencen() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
