package com.arc.dataapi.controller.facade;

import com.arc.dataapi.datatransferobject.DataCollectorDTO;
import com.arc.dataapi.exception.*;



public interface DataCollectorFacade {
    void validateDataCollectRequest(String remoteAddr, String userAgent, DataCollectorDTO dataCollectorDTO) throws IpBlacklistedException, UaBlacklistedException, CustomerIdNotFoundException, DataCollectorRecordNotCompleateException, CustomerDisabledException;
    void sendEventDataCollectorRequest(String remoteAddr, String userAgent, DataCollectorDTO dataCollectorDTO, boolean validRequest);
}
