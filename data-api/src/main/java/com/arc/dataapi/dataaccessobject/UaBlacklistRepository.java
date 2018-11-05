package com.arc.dataapi.dataaccessobject;

import com.arc.dataapi.domainobject.UaBlacklistDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UaBlacklistRepository extends CrudRepository<UaBlacklistDO, String> {
}
