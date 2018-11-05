package com.arc.dataapi.controller.facade;

import com.arc.dataapi.datatransferobject.DataCollectorDTO;
import com.arc.dataapi.exception.*;
import com.arc.dataapi.service.CustomerService;
import com.arc.dataapi.service.IpBlacklistService;
import com.arc.dataapi.service.SenderService;
import com.arc.dataapi.service.UaBlacklistService;
import com.arc.dataevents.events.MyEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DataCollectorFacadeImpl implements DataCollectorFacade {

    private final IpBlacklistService ipBlacklistService;
    private final UaBlacklistService uaBlacklistService;
    private final CustomerService customerService;
    private final CommandGateway commandGateway;
    private final SenderService senderService;

    @Autowired
    public DataCollectorFacadeImpl(IpBlacklistService ipBlacklistService, UaBlacklistService uaBlacklistService, CustomerService customerService, CommandGateway commandGateway, SenderService senderService) {
        this.ipBlacklistService = ipBlacklistService;
        this.uaBlacklistService = uaBlacklistService;
        this.customerService = customerService;
        this.commandGateway = commandGateway;
        this.senderService = senderService;
    }

    @Override
    public void validateDataCollectRequest(String remoteAddr, String userAgent, DataCollectorDTO dataCollectorDTO) throws IpBlacklistedException, UaBlacklistedException, CustomerIdNotFoundException, DataCollectorRecordNotCompleateException, CustomerDisabledException {

        if (dataCollectorDTO == null || dataCollectorDTO.getCustomerID() == null || dataCollectorDTO.getRemoteIP() == null || dataCollectorDTO.getTagID() == null || dataCollectorDTO.getTimestamp() == null || dataCollectorDTO.getUserID() == null) {
            sendEventDataCollectorRequest(remoteAddr, userAgent, dataCollectorDTO, false);
            throw new DataCollectorRecordNotCompleateException("Datacollector request body not complete!");
        }
        if (ipBlacklistService.findIpBlacklistByIp(Long.parseLong(remoteAddr.replaceAll("\\D+",""))).isPresent()) {
//            sendEventDataCollectorRequest(remoteAddr, userAgent, dataCollectorDTO, false);
            throw new IpBlacklistedException("Ip is blacklisted!");
        }
        if (uaBlacklistService.findUaBlacklistByUa(userAgent).isPresent()) {
//            sendEventDataCollectorRequest(remoteAddr, userAgent, dataCollectorDTO, false);
            throw new UaBlacklistedException("User agent is blacklisted!");
        }
        if (!customerService.findCustomerById(dataCollectorDTO.getCustomerID()).isPresent()) {
//            sendEventDataCollectorRequest(remoteAddr, userAgent, dataCollectorDTO, false);
            throw new CustomerIdNotFoundException("Customer not found!");
        }else{
            if(customerService.findCustomerById(dataCollectorDTO.getCustomerID()).get().getCustomerActive().equals(0)){
//                sendEventDataCollectorRequest(remoteAddr, userAgent, dataCollectorDTO, false);
                throw new CustomerDisabledException("Customer is disabled exception!");
            }
        }
    }

    @Override
    public void sendEventDataCollectorRequest(String remoteAddr, String userAgent, DataCollectorDTO dataCollectorDTO, boolean validRequest) {
        senderService.send(new MyEvent("Hi there", remoteAddr, dataCollectorDTO, validRequest));
    }
}
