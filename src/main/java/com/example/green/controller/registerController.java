
package com.example.green.controller;
import javax.validation.Valid;
import com.example.green.dao.UserDao;
import com.example.green.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class registerController {
    @Autowired
    UserDao userDao;

    final int FAIL = 0;

    @GetMapping("/add")
    public String register() {
        return "registerForm";
    }

    @PostMapping("/add")
    public String save(@Valid User user, BindingResult result, Model m, RedirectAttributes Successful) throws Exception {

        if (!result.hasErrors()) {
            int rowCnt = userDao.insertUser(user);
            if (rowCnt != FAIL) {
                Successful.addFlashAttribute("sf", "SF_OK");
                return "redirect:/login";
            }
        }
        return "registerForm";
    }



    private boolean isValid(User user) {
        return true;
    }
}