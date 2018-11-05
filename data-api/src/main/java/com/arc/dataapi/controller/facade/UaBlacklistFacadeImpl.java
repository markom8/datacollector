package com.arc.dataapi.controller.facade;

import com.arc.dataapi.datatransferobject.UaBlacklistDTO;
import com.arc.dataapi.service.UaBlacklistService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class UaBlacklistFacadeImpl implements UaBlacklistFacade{
    private UaBlacklistService uaBlacklistService;

    public UaBlacklistFacadeImpl(UaBlacklistService uaBlacklistService) {
        this.uaBlacklistService = uaBlacklistService;
    }

    @Override
    public UaBlacklistDTO saveUaBlacklist(UaBlacklistDTO uaBlacklistDTO) {
        return null;
    }
}
