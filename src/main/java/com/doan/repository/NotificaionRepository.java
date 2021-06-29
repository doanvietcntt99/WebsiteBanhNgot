package com.doan.repository;

import com.doan.model.Account;
import com.doan.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificaionRepository extends JpaRepository<Notification, Integer> {
    @Query("SELECT a FROM Notification a WHERE a.status = true")
    List<Notification> getListActiveNotification();
}
