package models;

import java.io.FileReader;
import java.io.Serializable;
import java.util.Date;
import java.util.Properties;


import com.fasterxml.jackson.annotation.JsonProperty;
import services.Implementation;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterPostInfoPojo implements Serializable {

    public long twitterHandle;
    public Date creationDate;
    public String userName;
    public String profileImgUrl;
    public String tweetMessage;

    public void setTweetMessage(Status status)
    {
        this.tweetMessage=status.getText();
    }

    @JsonProperty
    public String getTweetMessage()
    {return tweetMessage;}

    public void setUserName(Status status)
    {
        this.userName=status.getUser().getName();
    }

    @JsonProperty
    public String getUserName()
    {
        return userName;
    }

    public void setCreationDate(Status status)
    {
        this.creationDate=status.getCreatedAt();
    }

    @JsonProperty
    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setTwitterHandle(Status status)
    {
        this.twitterHandle= status.getId();
    }

    @JsonProperty
    public long getTwitterHandle()
    {
        return twitterHandle;
    }

    public void setProfileImgUrl(Status status)
    {
        this.profileImgUrl=status.getUser().get400x400ProfileImageURL();
    }

    @JsonProperty
    public String getProfileImgUrl()
    {
        return profileImgUrl;
    }



}
