package com.arc.datastatistics.rest.data;


import com.arc.datastatistics.query.data.DataEntry;
import com.arc.datastatistics.query.data.DataEntryRepository;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    private final DataEntryRepository dataEntryRepository;

    public DataController(DataEntryRepository dataEntryRepository) {
        this.dataEntryRepository = dataEntryRepository;
    }

    @RequestMapping(value = "/api/data", method = RequestMethod.GET)
    @ResponseBody
    public Page<DataEntry> findlAll(){
        return (Page<DataEntry>) dataEntryRepository.findAll();
    }
}
