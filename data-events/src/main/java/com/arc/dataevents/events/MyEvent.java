/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.arc.dataevents.events;



import com.arc.dataapi.datatransferobject.DataCollectorDTO;

import java.io.Serializable;

public class MyEvent implements Serializable {

  private String greeting;

  private String remoteAddr;

  private String userAgent;

  private DataCollectorDTO dataCollectorDTO;

  private boolean validRequest;

  private MyEvent() {
  }

  public MyEvent(String greeting) {
        this.greeting = greeting;
  }

    public MyEvent(String greeting, String remoteAddr, DataCollectorDTO dataCollectorDTO, boolean validRequest) {
        this.greeting = greeting;
        this.remoteAddr = remoteAddr;
        this.userAgent = userAgent;
        this.dataCollectorDTO = dataCollectorDTO;
        this.validRequest = validRequest;
  }

    public String getGreeting() {
    return greeting;
  }

  @Override
  public String toString() {
    return this.greeting;
  }

  public String getRemoteAddr() {
    return remoteAddr;
  }

  public void setRemoteAddr(String remoteAddr) {
    this.remoteAddr = remoteAddr;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public DataCollectorDTO getDataCollectorDTO() {
    return dataCollectorDTO;
  }

  public void setDataCollectorDTO(DataCollectorDTO dataCollectorDTO) {
    this.dataCollectorDTO = dataCollectorDTO;
  }

  public boolean isValidRequest() {
    return validRequest;
  }

  public void setValidRequest(boolean validRequest) {
    this.validRequest = validRequest;
  }
}
