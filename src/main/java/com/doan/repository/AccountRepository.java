package com.doan.repository;

import com.doan.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE a.username = :username")
    Account findAccountByUsername(@Param("username") String username);

    @Query("SELECT a FROM Account a")
    List<Account> getAllAccount();

    @Query("SELECT a FROM Account a WHERE a.status = true")
    List<Account> getListActiveAccount();

    @Query("SELECT a FROM Account a Where a.telegramUsername= :telegramUsername")
    Account findAccountByTelegram(@Param("telegramUsername") String telegramUsername);

    @Query("SELECT a FROM Account a WHERE a.idAccount= :idAccount")
    Account findAccountById(@Param("idAccount") Integer idAccount);

    @Query("SELECT a FROM Account a WHERE a.isAdmin = true")
    List<Account> getListAdminAccount();

    @Modifying(clearAutomatically = true)
    @Query("update Account a set a.password = :newPassword where a.idAccount = :idAccount")
    void UpdatePassword(@Param("newPassword") String newPassword,@Param("idAccount")  Integer idAccount);

    Account findByfullname(String fullname);

    @Query("SELECT a FROM Account a WHERE a.telegramUsername != null")
    List<Account> getListAccountBotID();

}
