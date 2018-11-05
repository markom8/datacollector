package com.arc.datastatistics.query.data;




import org.springframework.data.solr.repository.SolrCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DataEntryRepository extends SolrCrudRepository<DataEntry, String>
{
    List<DataEntry> findDataEntriesByTimestampIsAfter(LocalDateTime localDateTime);
}
