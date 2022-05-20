package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.Algorithm.AES256;
import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	AES256 aes256 = new AES256();
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/regist.do")
    private String registUser(User user, Model model) {
        try {
        	String cipherText = aes256.encrypt(user.getPassword());
        	user.setPassword(cipherText);
            userService.registUser(user);
            return "redirect:/user/login_form.do";
        } catch (Exception e) {
            model.addAttribute("errorMsg", "회원가입 중 문제가 발생하였습니다.");
            return "/user/regist_form.do";
        }
    }

    @PostMapping("/login.do")
    private String login(@RequestParam Map<String, String> map, HttpSession session, Model model) {
        try {
        	String text = aes256.encrypt(map.get("password"));
        	map.put("password", text);
            String name = userService.login(map);
            if (name != null) {
                session.setAttribute("userId", map.get("userid"));
                session.setAttribute("userName", name);
                return "redirect:/";
            } else {
                model.addAttribute("errorMsg", "아이디나 비밀번호가 일치하지 않습니다.");
                return "/user/login_form.do";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "로그인 실행 중 문제가 발생하였습니다.");
            return "/user/login_form.do";
        }
    }

    @GetMapping("/logout.do")
    private String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/update_form.do")
    private String updateForm(HttpSession session, Model model) throws Exception {
        String userid = (String) session.getAttribute("userId");
        User user = userService.getUser(userid);
        user.setPassword(aes256.decrypt(user.getPassword()));
        model.addAttribute("user", user);
        return "/user/update";
    }

    @PostMapping("/update.do")
    private String update(User user, Model model) {
        try {
        	user.setPassword(aes256.encrypt(user.getPassword()));
            userService.update(user);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("errorMsg", "회원정보 수정 중 문제가 발생하였습니다.");
            return "/user/update_form.do";
        }
    }

    @GetMapping
    private String search(@RequestParam String userid, @RequestParam String name, Model model) {
        String password = userService.getPw(userid, name);
        model.addAttribute("password", password);
        return "/user/search";
    }

}
