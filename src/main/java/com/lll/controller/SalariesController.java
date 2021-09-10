package com.lll.controller;


import com.lll.DTO.SalariesDTO;
import com.lll.entity.Salaries;
import com.lll.enums.ResultEnum;
import com.lll.exception.SalariesException;
import com.lll.form.SalariesForm;
import com.lll.service.SalariesService;
import com.lll.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;


/**
 * 工资表 Controller层
 * http://192.168.1.3/:8080/personnel/salaries/list
 * @author konvi
 * @version 1.0
 * @date 2021/9/3
 */
@Slf4j
@Controller
@RequestMapping("/salaries")
public class SalariesController
{
    @Autowired
    private SalariesService salariesService;

    /**
     * 分页查询工资表
     * @param page 默认为第一页
     * @param size 默认显示10条数据
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue ="1") Integer page, @RequestParam(value = "size",defaultValue = "10")Integer size, Map<String,Object> map)
    {
        PageRequest pageRequest = PageRequest.of(page - 1,size);

        Page<Salaries> salariesPageList = salariesService.findAll(pageRequest);

        // 带分页显示查询到的工资列表
        map.put("salariesPageList",salariesPageList);

        // 设置当前页
        map.put("currentPage",page);

        // 设置每页显示多少条数据
        map.put("size",size);

        return new ModelAndView("salaries/list",map);
    }

    /**
     * 弹出 工资表修改页面
     * @param empId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "empId",required = false)String empId,Map<String,Object>map)
    {
        if (empId != null)
        {
            Salaries salaries = salariesService.findById(empId);
            map.put("salaries",salaries);
        }
        return new ModelAndView("salaries/index",map);
    }


    /**
     * 保存/更新 工资表信息
     * @param salariesForm
     * @param bindingResult
     * @param request
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid SalariesForm salariesForm, BindingResult bindingResult, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg",bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url",request.getContextPath()+"/salaries/index");
            return new ModelAndView("common/error");
        }
        Salaries salaries = new Salaries();
        try
        {
            // 如果员工编号不为空,说明是修改工资信息
            if (StringUtils.hasText(salariesForm.getEmpId()))
            {
                salaries = salariesService.findById(salariesForm.getEmpId());
            } else // 如果员工编号为空,说明是新建工资信息
            {
                salariesForm.setEmpId(KeyUtil.genUniqueKey());
            }

            // 将form中的数据传到salaries对象中
            BeanUtils.copyProperties(salariesForm,salaries);

            // 最终金额
            BigDecimal salFinal;

            // 计算最终金额
            salFinal = salaries.getSalBase().add(salaries.getSalBonus()).add(salaries.getSalBenefits()).subtract(salaries.getSalFine());

            // 将最终金额传入数据库中
            salaries.setSalFinal(salFinal);

            // 工资信息入库
            salariesService.save(salaries);

        } catch (SalariesException e)
        {
            session.setAttribute("msg",e.getMessage());
            session.setAttribute("url","/personnel/salaries/index");
            return new ModelAndView("common/error");
        }

        session.setAttribute("msg", ResultEnum.EMPLOYEE_SALARIES_SUCCESS.getMessage());
        session.setAttribute("url","/personnel/salaries/list");
        return new ModelAndView("common/success");
    }

    /**
     * 删除 工资表信息
     * @param empId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("empId")String empId,Map<String,Object>map)
    {
        try
        {
            salariesService.delete(empId);
        } catch (SalariesException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/salaries/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.EMPLOYEE_SALARIES_SUCCESS.getMessage());
        map.put("url","/personnel/salaries/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "empName", required = false) String empName, Map<String, Object> map) {
        if (empName != null) {

        }
        return new ModelAndView("salaries/search", map);
    }


    @GetMapping("/result")
    public ModelAndView result(@RequestParam("empName") String empName, Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        SalariesDTO salariesDTO = new SalariesDTO();
        try {
            salariesDTO = salariesService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/sell
            map.put("url", contextPath + "/salaries/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        map.put("salaries", salariesDTO);
        return new ModelAndView("salaries/result", map);
    }
}
