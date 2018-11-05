package com.arc.datastatistics.query.data;


import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.time.ZonedDateTime;

@SolrDocument(solrCoreName = "data")
public class DataEntry {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "customerId", type = "long")
    Long customerId;

    @Indexed(name = "tagID", type = "long")
    Long tagID;

    @Indexed(name = "userID", type = "string")
    String userID;

    @Indexed(name = "remoteIP", type = "string")
    String remoteIP;

    @Indexed(name = "timestamp", type = "zonedatetime")
    ZonedDateTime timestamp;

    @Indexed(name = "remoteAddr", type = "string")
    String remoteAddr;

    @Indexed(name = "userAgent", type = "string")
    String userAgent;

    @Indexed(name = "validRequest", type = "boolean")
    boolean validRequest;


    public DataEntry(String id, Long customerId, Long tagID, String userID, String remoteIP, ZonedDateTime timestamp, String remoteAddr, String userAgent, boolean validRequest)
    {
        this.id = id;
        this.customerId = customerId;
        this.tagID = tagID;
        this.userID = userID;
        this.remoteIP = remoteIP;
        this.timestamp = timestamp;
        this.remoteAddr = remoteAddr;
        this.userAgent = userAgent;
        this.validRequest = validRequest;
    }

    //    public DataEntry(String id, Long customerId, Long tagID, String userID, String remoteIP, ZonedDateTime timestamp, String remoteAddr, String userAgent, boolean validRequest) {
//        this.id = id;
//        this.customerId = customerId;
//        this.tagID = tagID;
//        this.userID = userID;
//        this.remoteIP = remoteIP;
//        this.timestamp = timestamp;
//        this.remoteAddr = remoteAddr;
//        this.userAgent = userAgent;
//        this.validRequest = validRequest;
//    }
//
//    public DataEntry() {
//    }
}
