package com.arc.dataapi.service;

import com.arc.dataapi.dataaccessobject.UaBlacklistRepository;
import com.arc.dataapi.domainobject.UaBlacklistDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UaBlacklistServiceImpl implements UaBlacklistService{

    private UaBlacklistRepository uaBlacklistRepository;

    @Autowired
    public UaBlacklistServiceImpl(UaBlacklistRepository uaBlacklistRepository) {
        this.uaBlacklistRepository = uaBlacklistRepository;
    }

    @Override
    public Optional<UaBlacklistDO> findUaBlacklistByUa(String ua) {
        return uaBlacklistRepository.findById(ua);
    }

    @Override
    public UaBlacklistDO saveUaBlacklist(UaBlacklistDO uaBlacklistDO) {
        return uaBlacklistRepository.save(uaBlacklistDO);
    }

    @Override
    public void deleteUaBlacklist(UaBlacklistDO uaBlacklistDO) {
        uaBlacklistRepository.delete(uaBlacklistDO);
    }

    @Override
    public List<UaBlacklistDO> getAll() {
        return (List<UaBlacklistDO>) uaBlacklistRepository.findAll();
    }
}
