package com.arc.dataapi.dataaccessobject;

import com.arc.dataapi.domainobject.IpBlacklistDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpBlacklistRepository extends CrudRepository<IpBlacklistDO, Long> {
}
