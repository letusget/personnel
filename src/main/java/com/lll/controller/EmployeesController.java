package com.lll.controller;

import com.lll.entity.Employees;
import com.lll.exception.PersonnelExcetption;
import com.lll.form.EmployeeForm;
import com.lll.service.EmployeesService;
import com.lll.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
 * 员工信息
 * http://192.168.1.3:8080/personnel/employees/list
 */
@Controller
@RequestMapping("/employees")
public class EmployeesController
{
    //员工 Service
    @Autowired
    private EmployeesService employeesService;

    /**
     * 员工列表
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map)
    {
        PageRequest pageRequest=PageRequest.of(page-1,size);

        //分页查询商品列表
        Page<Employees> employeesPageList=employeesService.findAll(pageRequest);

        //设置商品分页列表
        map.put("employeesPageList",employeesPageList);
        //设置当前页
        map.put("currentPage",page);
        //设置每页显示多少条数据
        map.put("pageSize",size);

        return new ModelAndView("employees/list",map);

    }

    /**
     * 修改和新增员工使用同一个页面
     * 区别是在修改时是有 员工ID的
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value="empId",required = false)String empId,Map map)
    {
        if (StringUtils.hasText(empId))
        {
            //根据员工id 查询员工信息
            Employees employees=employeesService.findByEmpId(empId);
            //设置员工信息
            map.put("employee",employees);
        }
        //查询部门信息
        //TODO 部门信息
        /*
        List<ProductCategory> productCategoryList = productCategoryService.findAll();

        map.put("categoryList", productCategoryList);

        return new ModelAndView("product/index",map);
         */

        //TODO 将代码转换为显示的信息
        //TODO 新增的入职时间 由系统确定
        //TODO 照片 和 身份证号码 显示有问题


        return new ModelAndView("employees/index",map);

    }

    /**
     * 新增员工
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid EmployeeForm form, BindingResult bindingResult, HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg",bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url",request.getContextPath()+"employees/index");
            return new ModelAndView("common/error");
        }
        Employees employees=new Employees();
        try
        {
            //如果empId 有值，则说明是修改
            if (StringUtils.hasText(form.getEmpId()))
            {
                employees=employeesService.findByEmpId(form.getEmpId());
            }
            else
            {
                form.setDepId(KeyUtil.genUniqueKey());
            }
            //将form 中的对象 copy 给employees
            BeanUtils.copyProperties(form,employees);
            //保存 员工信息
            employeesService.save(employees);
        }catch (PersonnelExcetption e)
        {
            session.setAttribute("msg",e.getMessage());
            session.setAttribute("url",request.getContextPath()+"employees/index");
            return new ModelAndView("common/error");
        }
        session.setAttribute("url",request.getContextPath()+"employees/list");
        return new ModelAndView("common/success");

    }



}
