package com.arc.datastatistics.query.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DataEntryRepository extends JpaRepository<DataEntry, Long>
{
    List<DataEntry> findDataEntriesByTimestampIsAfter(LocalDateTime localDateTime);
}
