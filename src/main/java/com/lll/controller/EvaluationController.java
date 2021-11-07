package com.lll.controller;

import com.lll.DTO.EmployeesDTO;
import com.lll.DTO.EvaluationDTO;
import com.lll.entity.Departments;
import com.lll.entity.Employees;
import com.lll.entity.Evaluation;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.form.EvaluationForm;
import com.lll.service.EvaluationService;
import com.lll.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/evaluation")
@Slf4j
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
    @GetMapping("/list2")
    public ModelAndView list2(@RequestParam(value = "page",defaultValue = "1") Integer page,
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

        return new ModelAndView("evaluation/list2",map);

    }



    /**
     * 弹出修改页面
     * @param evaId
     * @param map
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "evaId", required = false) String evaId, Map<String, Object> map)
    {
        if (evaId != null)
        {
            Evaluation evaluation = evaluationService.findById(evaId);
            map.put("evaluation", evaluation);

            Integer sum=0;
            if (evaluation.getEvaVacate() <= 3){
                sum = 90 - evaluation.getEvaAbsence()*20 - evaluation.getEvaLate()*5 + evaluation.getEvaOvertime()*1;
            }else{
                sum = 90 - evaluation.getEvaAbsence()*20 - evaluation.getEvaLate()*5 - (evaluation.getEvaVacate()-3)*5 + evaluation.getEvaOvertime()*1;
            }

            if (sum>=90)
            {
                evaluation.setEvaLevel("A");
            }else if (sum<90 && sum>=80){
                evaluation.setEvaLevel("B");
            }else if (sum<80 && sum>=70){
                evaluation.setEvaLevel("C");
            }else if (sum<70 && sum>=60){
                evaluation.setEvaLevel("D");
            }else if (sum<60){
                evaluation.setEvaLevel("E");
            }


            map.put("evaluation", evaluation);
            //System.out.println(evaluation.getEmpId());
            //System.out.println(evaluation.getEvaLevel());

        }
        //System.out.println("test2");
        return new ModelAndView("evaluation/index", map);
    }
    @GetMapping("/index1")
    public ModelAndView index1(@RequestParam(value = "evaId", required = false) String evaId, Map<String, Object> map)
    {
        if (evaId != null)
        {
            //System.out.println("test1");
            Evaluation evaluation = evaluationService.findById(evaId);
            map.put("evaluation", evaluation);
            Integer sum=0;
            if (evaluation.getEvaVacate() <= 3){
                sum = 90 - evaluation.getEvaAbsence()*20 - evaluation.getEvaLate()*5 + evaluation.getEvaOvertime()*1;
            }else{
                sum = 90 - evaluation.getEvaAbsence()*20 - evaluation.getEvaLate()*5 - (evaluation.getEvaVacate()-3)*5 + evaluation.getEvaOvertime()*1;
            }

            if (sum>=90)
            {
                evaluation.setEvaLevel("A");
            }else if (sum<90 && sum>=80){
                evaluation.setEvaLevel("B");
            }else if (sum<80 && sum>=70){
                evaluation.setEvaLevel("C");
            }else if (sum<70 && sum>=60){
                evaluation.setEvaLevel("D");
            }else if (sum<60){
                evaluation.setEvaLevel("E");
            }

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
            if (StringUtils.hasText(form.getEvaId()))
            {
                evaluation = evaluationService.findByEvaId(form.getEvaId());
            }
            else
            {
                form.setEvaId(KeyUtil.genUniqueKey());
            }

            //System.out.println(form.getEvaId());
            //System.out.println(form.getEmpId());
            //System.out.println(form.getEvaLevel());

            BeanUtils.copyProperties(form,evaluation);

            //System.out.println(evaluation.getEvaId());
            //System.out.println(evaluation.getEmpId());
            //System.out.println(evaluation.getEvaLevel());

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
            if (StringUtils.hasText(form.getEvaId()))
            {
                evaluation = evaluationService.findByEvaId(form.getEvaId());
            } else
            {
                form.setEvaId(KeyUtil.genUniqueKey());
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
    public ModelAndView delete(@RequestParam("evaId")String evaId,Map<String,Object>map)
    {
        try
        {
            evaluationService.delete(evaId);
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
    public ModelAndView delete1(@RequestParam("evaId")String evaId,Map<String,Object>map)
    {
        try
        {
            evaluationService.delete(evaId);
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

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam(value = "empName", required = false) String empName,
                               @RequestParam(value = "evaLevel", required = false) String evaLevel,
                               Map<String, Object> map) {

        if (empName != null && evaLevel != null) {

        }
        return new ModelAndView("evaluation/search", map);
    }

    @GetMapping(value = "/search1")
    public ModelAndView search1(@RequestParam(value = "empName", required = false) String empName,
                                @RequestParam(value = "evaLevel", required = false) String evaLevel,
                                Map<String, Object> map) {

        if (empName != null && evaLevel != null) {

        }
        return new ModelAndView("evaluation/search1", map);
    }

    @GetMapping("/result")
    public ModelAndView result(@RequestParam("empName") String empName,
                               Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        try {
            evaluationDTO = evaluationService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/evaluation/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }

        map.put("evaluation", evaluationDTO);
        return new ModelAndView("evaluation/result", map);
    }

    @GetMapping("/result1")
    public ModelAndView result1(@RequestParam("empName") String empName,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        try {
            evaluationDTO = evaluationService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/evaluation/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }

        map.put("evaluation", evaluationDTO);
        return new ModelAndView("evaluation/result1", map);
    }

    @GetMapping("/result2")
    public ModelAndView result2(@RequestParam("evaLevel") String evaLevel,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Evaluation> evaluationList = evaluationService.findByEvaLevel(evaLevel);
        try {
            List<Evaluation> evaluation1 = evaluationService.findByEvaLevel(evaLevel);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/evaluation/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesList.size());
        if (evaluationList.size()==0){
            map.put("url", contextPath + "/personnel/evaluation/search");
            return new ModelAndView("common/error6", map);
        }
        map.put("evaluationList", evaluationList);
        return new ModelAndView("evaluation/result2", map);
    }

    @GetMapping("/result3")
    public ModelAndView result3(@RequestParam("evaLevel") String evaLevel,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Evaluation> evaluationList = evaluationService.findByEvaLevel(evaLevel);
        try {
            List<Evaluation> evaluation1 = evaluationService.findByEvaLevel(evaLevel);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/evaluation/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesList.size());
        if (evaluationList.size()==0){
            map.put("url", contextPath + "/personnel/evaluation/search1");
            return new ModelAndView("common/error6", map);
        }
        map.put("evaluationList", evaluationList);
        return new ModelAndView("evaluation/result3", map);
    }
}
