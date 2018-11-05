package com.arc.dataapi.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ip_blacklist")
public class IpBlacklistDO {

    @Id
    @Column(name = "ip")
    @NotNull(message = "IP can not be null!")
    private Long ip;

    public IpBlacklistDO() {
    }

    public IpBlacklistDO(@NotNull(message = "IP can not be null!") Long ip) {
        this.ip = ip;
    }

    public Long getIp() {
        return ip;
    }

    public void setIp(Long ip) {
        this.ip = ip;
    }
}
