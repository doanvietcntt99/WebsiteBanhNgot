package com.doan.service;

import com.doan.model.Account;
import com.doan.repository.AccountRepository;
import com.doan.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Configurable
public class AccountService {

    @Autowired
    public AccountRepository repository;

    public List<Account> getListAccountBotID(){return repository.getListAccountBotID();}

    public Account saveAccount(Account account){
        return repository.save(account);
    }
    public List<Account> saveAccounts(List<Account> accountList){
        return repository.saveAll(accountList);
    }
    public Account getAccountByTelegramUsername(String Telegram_Username){
        return repository.findAccountByTelegram(Telegram_Username);
    }
    public boolean execStartTelegram(String usernameTelegram, Long botIdTelegram){
        try {
            Account account = repository.findAccountByTelegram(usernameTelegram);
            account.setBotId(botIdTelegram);
            account.setUpdateAt(new Date());
            repository.save(account);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean execEndTelegram(String usernameTelegram){
        try {
            Account account = repository.findAccountByTelegram(usernameTelegram);
            account.setBotId(null);
            account.setUpdateAt(new Date());
            repository.save(account);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public List<Account> getAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Account getAccountByFullName(String name) {
        return repository.findByfullname(name);
    }

    public String deleteAccount(int id) {
        repository.deleteById(id);
        return "Account removed !! " + id;
    }

    public Account updateAccount(Account Account) {
//        Account existingAccount = repository.findById(Account.getId()).orElse(null);
//        existingAccount.setName(Account.getName());
//        existingAccount.setQuantity(Account.getQuantity());
//        existingAccount.setPrice(Account.getPrice());
        return repository.save(Account);
    }

    public List<Account> getAdminAccount() {
        return repository.getListAdminAccount();
    }
}
