package com.arc.dataapi.controller;


import com.arc.dataapi.controller.facade.DataCollectorFacade;
import com.arc.dataapi.datatransferobject.DataCollectorDTO;
import com.arc.dataapi.exception.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/datacollector")
public class DataCollectorController {

    private final static Logger logger = LoggerFactory.getLogger(DataCollectorController.class);

    private final CommandGateway commandGateway;

    private final DataCollectorFacade dataCollectorFacade;

    public DataCollectorController(CommandGateway commandGateway, DataCollectorFacade dataCollectorFacade) {
        this.commandGateway = commandGateway;
        this.dataCollectorFacade = dataCollectorFacade;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DataCollectorDTO collectData(@RequestBody(required = false) DataCollectorDTO dataCollectorDTO, HttpServletRequest request) throws CustomerDisabledException, CustomerIdNotFoundException, IpBlacklistedException, DataCollectorRecordNotCompleateException, UaBlacklistedException {
        String remoteAddr = "";
        String userAgent = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            userAgent = request.getHeader("User-Agent");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        dataCollectorFacade.validateDataCollectRequest(remoteAddr, userAgent, dataCollectorDTO);
        dataCollectorFacade.sendEventDataCollectorRequest(remoteAddr, userAgent, dataCollectorDTO, true);
        return dataCollectorDTO;
    }
}
