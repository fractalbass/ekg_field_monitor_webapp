package com.paintedharmony.ekgfm.dao;

import com.paintedharmony.ekgfm.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
