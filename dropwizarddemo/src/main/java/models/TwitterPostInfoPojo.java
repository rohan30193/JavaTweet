package models;

import java.io.FileReader;
import java.util.Date;
import java.util.Properties;


import services.Implementation;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterPostInfoPojo {

    public long twitterHandle;
    public Date creationDate;
    public String userName;
    public String profileImgUrl;

    public void setUserName(Status status)
    {
        this.userName=status.getUser().getName();
    }
    public String getUserName()
    {
        return userName;
    }

    public void setCreationDate(Status status)
    {
        this.creationDate=status.getCreatedAt();
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setTwitterHandle(Status status)
    {
        this.twitterHandle= status.getId();
    }

    public long getTwitterHandle()
    {
        return twitterHandle;
    }

    public void setProfileImgUrl(Status status)
    {
        this.profileImgUrl=status.getUser().get400x400ProfileImageURL();
    }
    public String getProfileImgUrl()
    {
        return profileImgUrl;
    }



}
