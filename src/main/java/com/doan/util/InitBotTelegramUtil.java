package com.doan.util;

import com.doan.controller.TelegramController;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class InitBotTelegramUtil {
    public static void Init(){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramController());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
