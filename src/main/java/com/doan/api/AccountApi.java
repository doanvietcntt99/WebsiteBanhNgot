package com.doan.api;
import com.doan.model.Account;
import com.doan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class AccountApi {

    @Autowired
    private AccountService service;

    @GetMapping("/Account/Telegram/InsertBotId")
    public boolean execUpdateTelegramBotId(@RequestParam(name = "telegramUsername") String telegramUsername, @RequestParam(name = "botId") String botId) {
        return service.execStartTelegram(telegramUsername, Long.parseLong(botId));
    }
    @GetMapping("/Account/Telegram/DeleteBotId")
    public boolean execUpdateTelegramBotId(@RequestParam(name = "telegramUsername") String telegramUsername) {
        return service.execEndTelegram(telegramUsername);
    }
}
