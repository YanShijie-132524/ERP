package com.example.erp.service;

import com.example.erp.model.Product;
import com.example.erp.model.SaleRecord;
import com.example.erp.repository.ProductRepository;
import com.example.erp.repository.SaleRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRecordRepository saleRecordRepository;
    private final ProductRepository productRepository;

    public SaleService(SaleRecordRepository saleRecordRepository,
                       ProductRepository productRepository) {
        this.saleRecordRepository = saleRecordRepository;
        this.productRepository = productRepository;
    }

    public List<SaleRecord> findAll() {
        return saleRecordRepository.findAll();
    }

    public SaleRecord save(SaleRecord record) {
        Product product = record.getProduct();
        product.setStock(product.getStock() - record.getQuantity());
        productRepository.save(product);
        return saleRecordRepository.save(record);
    }
}
