package com.doan.controller;

import com.doan.model.Account;
import com.doan.repository.AccountRepository;
import com.doan.service.AccountService;
import com.doan.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/login")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("idAccount")!= null){
            return "redirect:/admin";
        } else {
            Account account = new Account();
            model.addAttribute("account", account);
            return "DangNhap";
        }

    }
    @PostMapping("/execLogin")
    public String execLogin (Model model, @ModelAttribute("account") Account a, HttpServletRequest request) {
        String usernameLogin = a.getUsername();
        String passwordLogin = a.getPassword();
        String passwordLoginEncpyt = MD5Util.md5(passwordLogin);
        System.out.println("passwordLoginEncpyt  "+  passwordLoginEncpyt);
        Account account = null;
        try{
            account = accountRepository.findAccountByUsername(usernameLogin);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        if(account!=null){
            System.out.println("account password " + account.getPassword());
            if(account.isStatus()){
                if(account.getPassword().equals(passwordLoginEncpyt)){
                    HttpSession session = request.getSession();
                    session.setAttribute("idAccount", account.getIdAccount());
                    return "redirect:/admin";
                }
            }
        }
        System.out.println("account NULL");
        return "redirect:/login";

    }
    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("idAccount");
        return "redirect:/login";
    }
}
