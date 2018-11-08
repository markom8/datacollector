/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.arc.datastatistics;

import com.arc.dataevents.events.MyEvent;

import com.arc.datastatistics.query.data.DataEntry;
import com.arc.datastatistics.query.data.DataEntryRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

/*
 If ProcessingGroup is not set, then the package name is used.
 The name of the ProcessingGroup is also in the configuration
 and the name must match the name of the TrackingProcessor defined
 in the configuration. Axon adds automatically all the handler to the TrackingProcessor
 The class must be a @Component
 */
@Component
@ProcessingGroup("MyProcessor")
public class MyEventEventHandler {

  private final DataEntryRepository dataEntryRepository;

  @Autowired
  public MyEventEventHandler(DataEntryRepository dataEntryRepository) {
    this.dataEntryRepository = dataEntryRepository;
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(MyEventEventHandler.class);

  @EventHandler
  public void handleMyEvent(MyEvent myEvent){
    LOGGER.info("got the event {}", myEvent);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS Z");
    DataEntry dataEntry = new DataEntry(myEvent.getDataCollectorDTO().getCustomerID(), myEvent.getDataCollectorDTO().getTagID(), myEvent.getDataCollectorDTO().getUserID(), myEvent.getDataCollectorDTO().getRemoteIP(), myEvent.getDataCollectorDTO().getTimestamp(), myEvent.getRemoteAddr(), myEvent.getUserAgent(), myEvent.isValidRequest(), new Date());
    dataEntryRepository.save(dataEntry);
  }

}
