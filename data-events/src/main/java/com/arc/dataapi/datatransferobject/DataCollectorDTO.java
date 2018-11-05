package com.arc.dataapi.datatransferobject;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class DataCollectorDTO implements Serializable {


    private static final long serialVersionUID = -7091641856096918231L;

    Long customerID;
    Long tagID;
    String userID;
    String remoteIP;
    ZonedDateTime timestamp;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getTagID() {
        return tagID;
    }

    public void setTagID(Long tagID) {
        this.tagID = tagID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
