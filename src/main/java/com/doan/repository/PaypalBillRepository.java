package com.doan.repository;

import com.doan.model.PaypalBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalBillRepository extends JpaRepository<PaypalBill, Integer> {
}
