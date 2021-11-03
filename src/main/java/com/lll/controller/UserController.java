package com.lll.controller;

import com.lll.WebSecurityConfig;
import com.lll.entity.User;
import com.lll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * 管理员登录
 * http://192.168.1.3:8080/personnel/login
 * 登录用户：root 123456
 */
@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account, Model model)
    {
        return "common/index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "common/login";
    }

    @PostMapping("/loginVerify")
    public String loginVerify(String username, String password, Integer flag, HttpSession session)
    {
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        //user.setUserFlag(flag);


        //System.out.println("test");
        //System.out.println(user.getId());
        //System.out.println(user.getUsername());
        //System.out.println(user.getPassword());
        //System.out.println(user.getUserFlag());

        boolean verify= userService.verifyUser(user);
        Integer userFlag= userService.getUserFlag(user.getUsername());
        //boolean verify=true;

        if (verify)
        {
            session.setAttribute(WebSecurityConfig.SESSION_KEY,username);
            if (userFlag==0)
            {
                return "common/index";
            }
            else if(userFlag==1)
            {

                return "common/indexManager";
            }
            else if(userFlag==2)
            {
                return "common/indexEmployee";
            }
            else
            {
                return "common/error";
            }

        }
        else
        {
            return "common/login";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:common/login";
    }

}
