package com.arc.dataapi.service;

import com.arc.dataapi.domainobject.UaBlacklistDO;

import java.util.List;
import java.util.Optional;

public interface UaBlacklistService {
    Optional<UaBlacklistDO> findUaBlacklistByUa(String ua);

    UaBlacklistDO saveUaBlacklist(UaBlacklistDO uaBlacklistDO);

    void deleteUaBlacklist(UaBlacklistDO uaBlacklistDO);

    List<UaBlacklistDO> getAll();
}
