package com.arc.dataapi.service;

import com.arc.dataapi.dataaccessobject.IpBlacklistRepository;
import com.arc.dataapi.domainobject.IpBlacklistDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IpBlacklistServiceImpl implements IpBlacklistService {

    private IpBlacklistRepository ipBlacklistRepository;

    @Autowired
    public IpBlacklistServiceImpl(IpBlacklistRepository ipBlacklistRepository) {
        this.ipBlacklistRepository = ipBlacklistRepository;
    }

    @Override
    public Optional<IpBlacklistDO> findIpBlacklistByIp(Long ip) {
        return ipBlacklistRepository.findById(ip);
    }

    @Override
    public IpBlacklistDO saveIpBlacklist(IpBlacklistDO ipBlacklistDO) {
        return ipBlacklistRepository.save(ipBlacklistDO);
    }

    @Override
    public void deleteIpBlacklist(IpBlacklistDO ipBlacklistDO) {
        ipBlacklistRepository.delete(ipBlacklistDO);
    }

    @Override
    public List<IpBlacklistDO> getAll() {
        return (List<IpBlacklistDO>) ipBlacklistRepository.findAll();
    }
}
