package com.doan.repository;

import com.doan.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT a FROM Order a WHERE a.hasBeenPay = :hasBeenPay")
    List<Order> findOrderByHasBeenPay(@Param("hasBeenPay") Boolean hasBeenPay);

    @Query("SELECT a FROM Order a WHERE a.orderId = :orderId")
    Order findOrderByOrderId(@Param("orderId") Integer orderId);

    @Query("SELECT a FROM Order a WHERE a.phoneGuest = :phoneGuest")
    List<Order> findOrderByPhoneGuest(@Param("phoneGuest") String phoneGuest);

    @Query("SELECT a FROM Order a")
    List<Order> getAllOrder();

    @Query("SELECT a FROM Order a order By a.createAt DESC")
    List<Order> getAllOrderOrderByCreateDateDESC();

    @Query("select DISTINCT phoneGuest from Order")
    List<String> getDistinctGuest();
}
