package com.doan.repository;

import com.doan.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("SELECT a FROM Message a WHERE a.nameUser = :nameUser")
    Message findMessageByUser(@Param("nameUser") String nameUser);

    @Query("SELECT a FROM Message a WHERE a.status = :status")
    List<Message> getListMessageByStatus(@Param("status") String status);
}
