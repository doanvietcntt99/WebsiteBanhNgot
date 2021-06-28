package com.doan.service;

import com.doan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class ProductService {
    @Autowired
    public ProductRepository repository;
}
