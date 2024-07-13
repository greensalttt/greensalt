package com.example.green.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.green.dao.UserDao;
import com.example.green.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/login")
public class loginController {
    @Autowired
    UserDao userDao;
//
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

@GetMapping("/logout")
    public String logout(HttpSession session){
    session.invalidate();
    return  "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String toURL, String rememberID, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        if(!loginCheck(id, pwd)) {

            model.addAttribute("msg", "아이디 또는 비밀번호를 잘못 입력했습니다.");
            return "loginForm";

        }
        HttpSession session = request.getSession();
        session.setAttribute("userID", id);

        if(rememberID != null) {
            Cookie idcookie = new Cookie("userID", id);
            idcookie.setMaxAge(3600);
            response.addCookie(idcookie);
        }else {

            Cookie idcookie = new Cookie("userID", "");
            idcookie.setMaxAge(0);
            response.addCookie(idcookie);

        }

        toURL =  toURL==null || toURL.equals("") ? "/" : toURL;
;        return "redirect:"+toURL;

//        return "/index";
    }

    private boolean loginCheck(String id, String pwd) {
        User user = null;

        try {
            user = userDao.selectUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return user!=null && user.getPwd().equals(pwd);
  }
}