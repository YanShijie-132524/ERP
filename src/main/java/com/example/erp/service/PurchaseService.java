package com.example.erp.service;

import com.example.erp.model.Product;
import com.example.erp.model.PurchaseRecord;
import com.example.erp.repository.ProductRepository;
import com.example.erp.repository.PurchaseRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRecordRepository purchaseRecordRepository;
    private final ProductRepository productRepository;

    public PurchaseService(PurchaseRecordRepository purchaseRecordRepository,
                           ProductRepository productRepository) {
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.productRepository = productRepository;
    }

    public List<PurchaseRecord> findAll() {
        return purchaseRecordRepository.findAll();
    }

    public PurchaseRecord save(PurchaseRecord record) {
        Product product = record.getProduct();
        product.setStock(product.getStock() + record.getQuantity());
        productRepository.save(product);
        return purchaseRecordRepository.save(record);
    }
}
