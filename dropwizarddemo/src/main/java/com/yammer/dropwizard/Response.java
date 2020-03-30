package com.yammer.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import models.TwitterPostInfoPojo;

import java.util.List;

public class Response {

    private String guid;
    private Boolean success;
    private String message;
    private List<TwitterPostInfoPojo> response;

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

    public void setTimelineResponse(List<TwitterPostInfoPojo> response)
    {
        this.response=response;
    }

    @JsonProperty
    public List<TwitterPostInfoPojo> timeLineResponse()
    {
        return response;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
