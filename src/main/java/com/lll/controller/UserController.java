package com.lll.controller;

import com.lll.DTO.EmployeesDTO;
import com.lll.DTO.EvaluationDTO;
import com.lll.DTO.InformationDTO;
import com.lll.WebSecurityConfig;
import com.lll.entity.Employees;
import com.lll.entity.Information;
import com.lll.entity.User;
import com.lll.service.EmployeesService;
import com.lll.service.EvaluationService;
import com.lll.service.InfoService;
import com.lll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private EvaluationService evaluationService;

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

    /*@PostMapping("/loginVerify")
    public String loginVerify(String username, String password,
                              Integer flag, HttpSession session, Map<String, Object> map)
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

        List<Employees> employeesList=employeesService.findUpAll(user.getUsername());

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

                map.put("employeesList",employeesList);
                *//*return "common/indexEmployee";*//*
                return "employees/list2";

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

    }*/
    @PostMapping("/loginVerify")
    public ModelAndView loginVerify(String username, String password,
                                    Integer flag, HttpSession session, Map<String, Object> map)
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

       /* List<Employees> employeesList=employeesService.findUpAll(user.getUsername());
        System.out.println(employeesList.size());*/



        boolean verify= userService.verifyUser(user);
        Integer userFlag= userService.getUserFlag(user.getUsername());
        //boolean verify=true;

        if (verify)
        {
            session.setAttribute(WebSecurityConfig.SESSION_KEY,username);
            if (userFlag==0)
            {
                return new ModelAndView("common/index");
            }
            else if(userFlag==1)
            {

                //return "common/indexManager";
                return new ModelAndView("common/indexManager");
            }
            else if(userFlag==2)
            {
                EmployeesDTO employeesDTO=employeesService.findByEmpName(user.getUsername());
                InformationDTO informationDTO=infoService.findByEmpName(user.getUsername());
                EvaluationDTO evaluationDTO= evaluationService.findByEmpName(user.getUsername());
                map.put("employeesDTO",employeesDTO);
                map.put("informationDTO",informationDTO);
                map.put("evaluationDTO",evaluationDTO);
                /*return "common/indexEmployee";*/
                //return "employees/list2";
                return new ModelAndView("employees/list2",map);

            }
            else
            {
                //return "common/error";
                return new ModelAndView("common/error");
            }

        }
        else
        {
            //return "common/login";
            return new ModelAndView("common/login");
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:common/login";
    }

}
