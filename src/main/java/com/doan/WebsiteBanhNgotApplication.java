package com.doan;

import com.doan.util.InitBotTelegramUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsiteBanhNgotApplication {

	public static void main(String[] args) {
		InitBotTelegramUtil.Init();
		SpringApplication.run(WebsiteBanhNgotApplication.class, args);

	}

}
