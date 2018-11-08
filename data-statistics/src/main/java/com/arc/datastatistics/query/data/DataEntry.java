package com.arc.datastatistics.query.data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "data_entry")
public class DataEntry {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private Long customerId;

    @Column
    private Long tagID;

    @Column
    private String userID;

    @Column
    private String remoteIP;

    @Column
    private ZonedDateTime timestamp;

    @Column
    private String remoteAddr;

    @Column
    private String userAgent;

    @Column
    private boolean validRequest;

    @Column
    private Date eventRecived;

    public DataEntry(
        Long customerId, Long tagID, String userID, String remoteIP, ZonedDateTime timestamp, String remoteAddr, String userAgent, boolean validRequest,
        Date eventRecived)
    {
        this.customerId = customerId;
        this.tagID = tagID;
        this.userID = userID;
        this.remoteIP = remoteIP;
        this.timestamp = timestamp;
        this.remoteAddr = remoteAddr;
        this.userAgent = userAgent;
        this.validRequest = validRequest;
        this.eventRecived = eventRecived;
    }


    public Long getCustomerId()
    {
        return customerId;
    }


    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }


    public Long getTagID()
    {
        return tagID;
    }


    public void setTagID(Long tagID)
    {
        this.tagID = tagID;
    }


    public String getUserID()
    {
        return userID;
    }


    public void setUserID(String userID)
    {
        this.userID = userID;
    }


    public String getRemoteIP()
    {
        return remoteIP;
    }


    public void setRemoteIP(String remoteIP)
    {
        this.remoteIP = remoteIP;
    }


    public ZonedDateTime getTimestamp()
    {
        return timestamp;
    }


    public void setTimestamp(ZonedDateTime timestamp)
    {
        this.timestamp = timestamp;
    }


    public String getRemoteAddr()
    {
        return remoteAddr;
    }


    public void setRemoteAddr(String remoteAddr)
    {
        this.remoteAddr = remoteAddr;
    }


    public String getUserAgent()
    {
        return userAgent;
    }


    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }


    public boolean isValidRequest()
    {
        return validRequest;
    }


    public void setValidRequest(boolean validRequest)
    {
        this.validRequest = validRequest;
    }


    public Date getEventRecived()
    {
        return eventRecived;
    }


    public void setEventRecived(Date eventRecived)
    {
        this.eventRecived = eventRecived;
    }
}
