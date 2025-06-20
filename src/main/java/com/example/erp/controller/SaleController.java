package com.example.erp.controller;

import com.example.erp.model.SaleRecord;
import com.example.erp.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<SaleRecord> list() {
        return saleService.findAll();
    }

    @PostMapping
    public ResponseEntity<SaleRecord> create(@RequestBody SaleRecord record) {
        return ResponseEntity.ok(saleService.save(record));
    }
}
