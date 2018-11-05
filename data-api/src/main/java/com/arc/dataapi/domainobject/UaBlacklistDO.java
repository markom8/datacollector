package com.arc.dataapi.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ua_blacklist")
public class UaBlacklistDO {

    @Id
    @Column(name = "ua")
    @NotNull(message = "UA can not be null!")
    private String ua;

    public UaBlacklistDO() {
    }

    public UaBlacklistDO(@NotNull(message = "UA can not be null!") String ua) {
        this.ua = ua;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }
}
