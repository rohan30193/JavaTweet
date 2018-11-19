package com.yammer.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    private String guid;
    private Boolean success;
    private String message;

    public Response() {

    }

    @JsonProperty
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
