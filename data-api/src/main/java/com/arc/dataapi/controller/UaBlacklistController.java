package com.arc.dataapi.controller;

import com.arc.dataapi.controller.facade.UaBlacklistFacade;
import com.arc.dataapi.datatransferobject.UaBlacklistDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/uablacklist")
public class UaBlacklistController {

    private final UaBlacklistFacade uaBlacklistFacade;

    public UaBlacklistController(UaBlacklistFacade uaBlacklistFacade) {
        this.uaBlacklistFacade = uaBlacklistFacade;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UaBlacklistDTO savaUaBlacklist(UaBlacklistDTO uaBlacklistDTO){
        return uaBlacklistFacade.saveUaBlacklist(uaBlacklistDTO);
    }
}
