package com.yammer.dropwizard;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwitterResourceTest {


    @InjectMocks
    private TwitterResource resource = new TwitterResource();




    @Test
    public void tweetMessage() {
        Response responseMock =  mock(Response.class);
        when(responseMock.getMessage()).thenReturn("Message received");
        when(responseMock.getSuccess()).thenReturn(true);


    }

    @Test
    public void getTimeline() {
        Response responseMock=mock(Response.class);
        when(responseMock.getMessage()).thenReturn("Received Timeline");

    }
}