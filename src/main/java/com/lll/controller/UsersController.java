package com.lll.controller;

import com.lll.entity.Users;
import com.lll.enums.ResultEnum;
import com.lll.exception.SalariesException;
import com.lll.form.UsersForm;
import com.lll.service.UsersService;
import com.lll.utils.UserIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author konvi
 * @version 1.0
 * @date 2021/11/5
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UsersController
{
    @Autowired
    private UsersService usersService;

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "userId", required = false) String userId, Map<String, Object> map) {
        if (userId != null)
        {
            Users users = usersService.findById(userId);
            map.put("users",users);
        }
        return new ModelAndView("user/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid UsersForm usersForm, BindingResult bindingResult, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        // bindingResult.hasErrors()是为了验证@Valid后面的bean 里是否有不符合注解条件的错误信息
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg",bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url",request.getContextPath()+"/user/index");
            return new ModelAndView("common/error");
        }
        Users users = new Users();
        try
        {
            // 如果员工编号不为空,说明是修改工资信息
            // StringUtils.hasText(String) 若String值为null或''等,则返回值为false
            if (StringUtils.hasText(usersForm.getUserId()))
            {
                users = usersService.findById(usersForm.getUserId());
            } else // 如果员工编号为空,说明是新建工资信息
            {
                usersForm.setUserId(UserIdUtil.generateShortUuid());
            }

            // 将form中的数据传到salaries对象中
            BeanUtils.copyProperties(usersForm, users);

            users.setPassword("123456");

            // 用户信息入库
            usersService.save(users);

        } catch (SalariesException e)
        {
            session.setAttribute("msg",e.getMessage());
            session.setAttribute("url","/personnel/user/index");
            return new ModelAndView("common/error");
        }

        session.setAttribute("msg", ResultEnum.USER_SUCCESS.getMessage());
        session.setAttribute("url","/personnel/employees/list");
        return new ModelAndView("common/success");
    }
}
