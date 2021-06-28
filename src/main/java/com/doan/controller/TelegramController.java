package com.doan.controller;


import com.doan.model.Account;
import com.doan.repository.AccountRepository;
import com.doan.service.AccountService;
import com.doan.util.HTTPUtil;
import com.doan.util.ReadConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.List;

@EnableJpaRepositories
public class TelegramController extends TelegramLongPollingBot {


    public String getBotUsername() {
        return ReadConfigUtil.readKey("namebot");
    }

    public String getBotToken() {
        return ReadConfigUtil.readKey("bottokentelegram");
    }

    @Autowired
    private AccountService service;


    public void onUpdateReceived(Update update){
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();
        HTTPUtil httpUtil = new HTTPUtil();
        if(command.equals("/start")){
            String usernameTelegram = update.getMessage().getFrom().getUserName();
            Long botIdTelegram = update.getMessage().getChatId();
            System.out.println(usernameTelegram);
            System.out.println(botIdTelegram);
            try {
                httpUtil.GetRequest(usernameTelegram,botIdTelegram, HTTPUtil.HTTP_URL_INSERT);
                System.out.println("Cập nhật thành công "+ botIdTelegram+ " cho Username: "+usernameTelegram);
                message.setText("Bạn sẽ nhận được thông báo khi hệ thống nhận được sự thay đổi!");
            } catch (Exception e) {
                e.printStackTrace();
                message.setText("Không tìm thấy Username của bạn! Vui lòng kiểm tra lại!");
            }
        } else if (command.equals("/end")){
            String usernameTelegram = update.getMessage().getFrom().getUserName();
            try {
                httpUtil.GetRequest(usernameTelegram, HTTPUtil.HTTP_URL_DELETE);
                System.out.println("Xóa BotId thành công cho Username: "+usernameTelegram);
                message.setText("Tạm dừng nhận thông báo khi hệ thống nhận được sự thay đổi!");
            } catch (IOException e) {
                e.printStackTrace();
                message.setText("Không tìm thấy Username của bạn! Vui lòng kiểm tra lại!");
            }
        }
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void callExec(String input, List<Account> accountList){
        TelegramController telegramBot = new TelegramController();
        for (Account account: accountList) {
            if(account.getBotId() != null){
                telegramBot.sendMessage(input, Integer.parseInt(String.valueOf(account.getBotId())));
            }
        }
    }
    public void sendMessage(String message, Integer BotId){
        SendMessage messageDetail = new SendMessage();
        messageDetail.setText(message);
        messageDetail.setChatId(String.valueOf(BotId));
        try {
            execute(messageDetail);
            System.out.println("Done Send Message!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
