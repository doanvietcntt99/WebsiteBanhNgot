package com.doan.service;

import com.doan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class OrderService {
    @Autowired
    public OrderRepository repository;
}
