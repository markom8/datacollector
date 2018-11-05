/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.arc.datastatistics;

import com.arc.dataevents.events.MySagaEndEvent;
import com.arc.dataevents.events.MySagaStartEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.SagaLifecycle;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Saga(sagaStore = "mySagaStore", configurationBean = "mySagaConfiguration")
@ProcessingGroup("MyProcessor")
public class MySaga {

  private static final Logger LOGGER = LoggerFactory.getLogger(MySaga.class);

  @StartSaga
  @SagaEventHandler(associationProperty = "startId")
  public void handleStart(MySagaStartEvent startEvent) {
    SagaLifecycle.associateWith("endId", startEvent.getStartId());
    LOGGER.info("Saga started with startId {}", startEvent.getStartId());
  }

  @SagaEventHandler(associationProperty = "endId")
  @EndSaga
  public void handleEnd(MySagaEndEvent endEvent) {
    LOGGER.info("Saga ended with the endId {}", endEvent.getEndId());
  }
}
