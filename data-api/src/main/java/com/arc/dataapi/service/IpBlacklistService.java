package com.arc.dataapi.service;

import com.arc.dataapi.domainobject.IpBlacklistDO;

import java.util.List;
import java.util.Optional;

public interface IpBlacklistService {

    Optional<IpBlacklistDO> findIpBlacklistByIp(Long id);

    IpBlacklistDO saveIpBlacklist(IpBlacklistDO ipBlacklistDO);

    void deleteIpBlacklist(IpBlacklistDO ipBlacklistDO);

    List<IpBlacklistDO> getAll();
}
