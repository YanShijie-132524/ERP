package com.example.erp.controller;

import com.example.erp.model.PurchaseRecord;
import com.example.erp.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<PurchaseRecord> list() {
        return purchaseService.findAll();
    }

    @PostMapping
    public ResponseEntity<PurchaseRecord> create(@RequestBody PurchaseRecord record) {
        return ResponseEntity.ok(purchaseService.save(record));
    }
}
