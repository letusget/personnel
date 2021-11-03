package com.lll.controller;

import com.lll.entity.Evaluation;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.form.EvaluationForm;
import com.lll.service.EvaluationService;
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

@Controller
@RequestMapping("/evaluation")
public class EvaluationController
{
    @Autowired
    private EvaluationService evaluationService;

    /**
     * 员工列表
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map)
    {
        PageRequest pageRequest=PageRequest.of(page-1,size);

        //分页查询员工列表
        Page<Evaluation> evaluationPageList=evaluationService.findAll(pageRequest);

        //设置员工分页列表
        map.put("evaluationPageList",evaluationPageList);
        //设置当前页
        map.put("currentPage",page);
        //设置每页显示多少条数据
        map.put("pageSize",size);

        return new ModelAndView("evaluation/list",map);

    }
    @GetMapping("/list1")
    public ModelAndView list1(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map)
    {
        PageRequest pageRequest=PageRequest.of(page-1,size);

        //分页查询员工列表
        Page<Evaluation> evaluationPageList=evaluationService.findAll(pageRequest);

        //设置员工分页列表
        map.put("evaluationPageList",evaluationPageList);
        //设置当前页
        map.put("currentPage",page);
        //设置每页显示多少条数据
        map.put("pageSize",size);

        return new ModelAndView("evaluation/list1",map);

    }


    /**
     * 弹出修改页面
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "empId", required = false) String empId, Map<String, Object> map)
    {
        if (empId != null)
        {
            Evaluation evaluation = evaluationService.findById(empId);
            map.put("evaluation", evaluation);
        }
        return new ModelAndView("evaluation/index", map);
    }
    @GetMapping("/index1")
    public ModelAndView index1(@RequestParam(value = "empId", required = false) String empId, Map<String, Object> map)
    {
        if (empId != null)
        {
            Evaluation evaluation = evaluationService.findById(empId);
            map.put("evaluation", evaluation);
        }
        return new ModelAndView("evaluation/index1", map);
    }

    /** 新增 */
    @PostMapping("/save")
    public ModelAndView save(@Valid EvaluationForm form,
                             BindingResult bindingResult,
                             HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg", bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url", request.getContextPath() + "/evaluation/index");
            return new ModelAndView("common/error");
        }

        Evaluation evaluation = new Evaluation();
        try
        {
            if (StringUtils.hasText(form.getEmpId()))
            {
                evaluation = evaluationService.findById(form.getEmpId());
            } else
            {
                form.setEmpId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form,evaluation);
            evaluationService.save(evaluation);   // 保存/更新
        } catch (PersonnelException e)
        {
            session.setAttribute("msg", e.getMessage());
            session.setAttribute("url", request.getContextPath() + "/evaluation/index");
            return new ModelAndView("common/error");
        }
        session.setAttribute("msg", ResultEnum.EMPLOYEE_EVALUATION_SUCCESS.getMessage());
        session.setAttribute("url", request.getContextPath() + "/evaluation/list");
        return new ModelAndView("common/success");
    }
    @PostMapping("/save1")
    public ModelAndView save1(@Valid EvaluationForm form,
                             BindingResult bindingResult,
                             HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg", bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url", request.getContextPath() + "/evaluation/index1");
            return new ModelAndView("common/error");
        }

        Evaluation evaluation = new Evaluation();
        try
        {
            if (StringUtils.hasText(form.getEmpId()))
            {
                evaluation = evaluationService.findById(form.getEmpId());
            } else
            {
                form.setEmpId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form,evaluation);
            evaluationService.save(evaluation);   // 保存/更新
        } catch (PersonnelException e)
        {
            session.setAttribute("msg", e.getMessage());
            session.setAttribute("url", request.getContextPath() + "/evaluation/index1");
            return new ModelAndView("common/error");
        }
        session.setAttribute("msg", ResultEnum.EMPLOYEE_EVALUATION_SUCCESS.getMessage());
        session.setAttribute("url", request.getContextPath() + "/evaluation/list1");
        return new ModelAndView("common/success");
    }

    /** 删除 */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("empId")String empId,Map<String,Object>map)
    {
        try
        {
            evaluationService.delete(empId);
        } catch (PersonnelException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/evaluation/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.EMPLOYEE_EVALUATION_SUCCESS.getMessage());
        map.put("url","/personnel/evaluation/list");
        return new ModelAndView("common/success",map);
    }
    @GetMapping("/delete1")
    public ModelAndView delete1(@RequestParam("empId")String empId,Map<String,Object>map)
    {
        try
        {
            evaluationService.delete(empId);
        } catch (PersonnelException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/evaluation/list1");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.EMPLOYEE_EVALUATION_SUCCESS.getMessage());
        map.put("url","/personnel/evaluation/list1");
        return new ModelAndView("common/success",map);
    }

}
