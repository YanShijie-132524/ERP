package com.example.erp.repository;

import com.example.erp.model.SaleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRecordRepository extends JpaRepository<SaleRecord, Long> {
}
