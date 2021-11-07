package com.lll.controller;

import com.lll.DTO.InformationDTO;
import com.lll.entity.Information;
import com.lll.enums.ResultEnum;
import com.lll.exception.SalariesException;
import com.lll.form.InformationForm;
import com.lll.service.InfoService;
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

/**
 * 背景表 Controller层
 * http://192.168.1.3/:8080/personnel/info/list
 * @author konvi
 * @version 1.0
 * @date 2021/9/3
 */
@Slf4j
@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

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

        Page<Information> infoPageList = infoService.findAll(pageRequest);

        // 带分页显示查询到的工资列表
        map.put("infoPageList",infoPageList);

        // 设置当前页
        map.put("currentPage",page);

        // 设置每页显示多少条数据
        map.put("size",size);

        return new ModelAndView("info/list",map);
    }
    @GetMapping("/list1")
    public ModelAndView list1(@RequestParam(value = "page",defaultValue ="1") Integer page, @RequestParam(value = "size",defaultValue = "10")Integer size, Map<String,Object> map)
    {
        PageRequest pageRequest = PageRequest.of(page - 1,size);

        Page<Information> infoPageList = infoService.findAll(pageRequest);

        // 带分页显示查询到的工资列表
        map.put("infoPageList",infoPageList);

        // 设置当前页
        map.put("currentPage",page);

        // 设置每页显示多少条数据
        map.put("size",size);

        return new ModelAndView("info/list1",map);
    }
    @GetMapping("/list2")
    public ModelAndView list2(@RequestParam(value = "page",defaultValue ="1") Integer page, @RequestParam(value = "size",defaultValue = "10")Integer size, Map<String,Object> map)
    {
        PageRequest pageRequest = PageRequest.of(page - 1,size);

        Page<Information> infoPageList = infoService.findAll(pageRequest);

        // 带分页显示查询到的工资列表
        map.put("infoPageList",infoPageList);

        // 设置当前页
        map.put("currentPage",page);

        // 设置每页显示多少条数据
        map.put("size",size);

        return new ModelAndView("info/list2",map);
    }

    /**
     * 弹出 背景表修改页面
     * @param infId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "infId",required = false)String infId,Map<String,Object>map)
    {
        if (infId != null)
        {
            Information information = infoService.findById(infId);
            map.put("information", information);
        }
        return new ModelAndView("info/index",map);
    }
    @GetMapping("/index1")
    public ModelAndView index1(@RequestParam(value = "infId",required = false)String infId,Map<String,Object>map)
    {
        if (infId != null)
        {
            Information information = infoService.findById(infId);
            map.put("information", information);
        }
        return new ModelAndView("info/index1",map);
    }
    @GetMapping("/index2")
    public ModelAndView index2(@RequestParam(value = "infId",required = false)String infId,Map<String,Object>map)
    {
        if (infId != null)
        {
            Information information = infoService.findById(infId);
            map.put("information", information);
        }
        return new ModelAndView("info/index2",map);
    }


    /**
     * 保存/更新 工资表信息
     * @param informationForm
     * @param bindingResult
     * @param request
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid InformationForm informationForm, BindingResult bindingResult, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        // bindingResult.hasErrors()是为了验证@Valid后面的bean 里是否有不符合注解条件的错误信息
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg",bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url",request.getContextPath()+"/info/index");
            return new ModelAndView("common/error");
        }
        Information information = new Information();
        try
        {

            // StringUtils.hasText(String) 若String值为null或''等,则返回值为false
            if (StringUtils.hasText(informationForm.getInfId()))
            {
                information = infoService.findById(informationForm.getInfId());
            } else // 如果员工编号为空,说明是新建工资信息
            {
                informationForm.setInfId(KeyUtil.genUniqueKey());
            }

            // 将form中的数据传到salaries对象中
            BeanUtils.copyProperties(informationForm, information);

            // 背景信息入库
            infoService.save(information);

        } catch (SalariesException e)
        {
            session.setAttribute("msg",e.getMessage());
            session.setAttribute("url", request.getContextPath()+"/info/index");
            return new ModelAndView("common/error");
        }

        session.setAttribute("msg", ResultEnum.EMPLOYEE_INFORMATION_SUCCESS.getMessage());
        session.setAttribute("url",request.getContextPath()+"/info/list");
        return new ModelAndView("common/success");
    }
    @PostMapping("/save1")
    public ModelAndView save1(@Valid InformationForm informationForm, BindingResult bindingResult, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        // bindingResult.hasErrors()是为了验证@Valid后面的bean 里是否有不符合注解条件的错误信息
        if (bindingResult.hasErrors())
        {
            session.setAttribute("msg",bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url",request.getContextPath()+"/info/index1");
            return new ModelAndView("common/error");
        }
        Information information = new Information();
        try
        {
            // 如果员工编号不为空,说明是修改工资信息
            // StringUtils.hasText(String) 若String值为null或''等,则返回值为false
            if (StringUtils.hasText(informationForm.getInfId()))
            {
                information = infoService.findById(informationForm.getInfId());
            } else // 如果员工编号为空,说明是新建工资信息
            {
                informationForm.setInfId(KeyUtil.genUniqueKey());
            }

            // 将form中的数据传到salaries对象中
            BeanUtils.copyProperties(informationForm, information);

            /*// 最终金额
            BigDecimal salFinal;

            // 计算最终金额
            salFinal = information.getSalBase().add(information.getSalBonus()).add(information.getSalBenefits()).subtract(information.getSalFine());

            // 将最终金额传入数据库中
            information.setSalFinal(salFinal);*/

            // 背景信息入库
            infoService.save(information);

        } catch (SalariesException e)
        {
            session.setAttribute("msg",e.getMessage());
            session.setAttribute("url","/personnel/info/index1");
            return new ModelAndView("common/error");
        }

        session.setAttribute("msg", ResultEnum.EMPLOYEE_INFORMATION_SUCCESS.getMessage());
        session.setAttribute("url","/personnel/info/lis1");
        return new ModelAndView("common/success");
    }

    /**
     * 删除 背景表信息
     * @param InfId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("InfId")String InfId,Map<String,Object>map)
    {
        try
        {
            infoService.delete(InfId);
        } catch (SalariesException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/info/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.EMPLOYEE_INFORMATION_SUCCESS.getMessage());
        map.put("url","/personnel/info/list");
        return new ModelAndView("common/success",map);
    }
    @GetMapping("/delete1")
    public ModelAndView delete1(@RequestParam("InfId")String InfId,Map<String,Object>map)
    {
        try
        {
            infoService.delete(InfId);
        } catch (SalariesException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/info/list1");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.EMPLOYEE_INFORMATION_SUCCESS.getMessage());
        map.put("url","/personnel/info/list1");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "empName", required = false) String empName,
                               @RequestParam(value = "infEducation", required = false) Integer infEducation,
                               @RequestParam(value = "infPolitical", required = false) Integer infPolitical,
                               @RequestParam(value = "infMarital", required = false) Integer infMarital,
                               Map<String, Object> map) {
        if (empName != null && infEducation != null && infPolitical != null && infMarital != null){

        }
        return new ModelAndView("info/search", map);
    }



    @GetMapping("/search1")
    public ModelAndView search1(@RequestParam(value = "empName", required = false) String empName,
                                @RequestParam(value = "infEducation", required = false) Integer infEducation,
                                @RequestParam(value = "infPolitical", required = false) Integer infPolitical,
                                @RequestParam(value = "infMarital", required = false) Integer infMarital,
                                Map<String, Object> map) {
        if (empName != null && infEducation != null && infPolitical != null && infMarital != null){

        }
        return new ModelAndView("info/search1", map);
    }


    @GetMapping("/result")
    public ModelAndView result(@RequestParam("empName") String empName, Map<String, Object> map, HttpServletRequest request)
    {
        String contextPath = "";
        InformationDTO informationDTO = new InformationDTO();
        try {
            informationDTO = infoService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("info", informationDTO);
        return new ModelAndView("info/result", map);
    }


    @GetMapping("/result2")
    public ModelAndView result2(@RequestParam("infEducation") String infEducation,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Information> informationList = infoService.findByInfEducation(infEducation);
        try {
            List<Information> information1 = infoService.findByInfEducation(infEducation);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesList.size());
        if (informationList.size()==0){
            map.put("url", contextPath + "/personnel/info/search");
            return new ModelAndView("common/error3", map);
        }
        map.put("informationList", informationList);
        return new ModelAndView("info/result2", map);
    }

    @GetMapping("/result3")
    public ModelAndView result3(@RequestParam("infPolitical") Integer infPolitical,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Information> infPoliticalList = infoService.findByInfPolitical(infPolitical);
        try {
            List<Information> information2 = infoService.findByInfPolitical(infPolitical);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesSexList.size());
        if (infPoliticalList.size()==0){
            map.put("url", contextPath + "/personnel/info/search");
            return new ModelAndView("common/error4", map);
        }
        map.put("infPoliticalList", infPoliticalList);
        return new ModelAndView("info/result3", map);
    }

    @GetMapping("/result4")
    public ModelAndView result4(@RequestParam("infMarital") Integer infMarital,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Information> infMaritalList = infoService.findByInfMarital(infMarital);
        try {
            List<Information> information3 = infoService.findByInfMarital(infMarital);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesSexList.size());
        if (infMaritalList.size()==0){
            map.put("url", contextPath + "/personnel/info/search");
            return new ModelAndView("common/error5", map);
        }
        map.put("infMaritalList", infMaritalList);
        return new ModelAndView("info/result4", map);
    }

    @GetMapping("/result1")
    public ModelAndView result1(@RequestParam("empName") String empName, Map<String, Object> map, HttpServletRequest request)
    {
        String contextPath = "";
        InformationDTO informationDTO = new InformationDTO();
        try {
            informationDTO = infoService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search1");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("info", informationDTO);
        return new ModelAndView("info/result1", map);
    }

    @GetMapping("/result5")
    public ModelAndView result5(@RequestParam("infEducation") String infEducation,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Information> informationList = infoService.findByInfEducation(infEducation);
        try {
            List<Information> information1 = infoService.findByInfEducation(infEducation);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesList.size());
        if (informationList.size()==0){
            map.put("url", contextPath + "/personnel/info/search1");
            return new ModelAndView("common/error3", map);
        }
        map.put("informationList", informationList);
        return new ModelAndView("info/result5", map);
    }

    @GetMapping("/result6")
    public ModelAndView result6(@RequestParam("infPolitical") Integer infPolitical,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Information> infPoliticalList = infoService.findByInfPolitical(infPolitical);
        try {
            List<Information> information2 = infoService.findByInfPolitical(infPolitical);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesSexList.size());
        if (infPoliticalList.size()==0){
            map.put("url", contextPath + "/personnel/info/search1");
            return new ModelAndView("common/error4", map);
        }
        map.put("infPoliticalList", infPoliticalList);
        return new ModelAndView("info/result6", map);
    }

    @GetMapping("/result7")
    public ModelAndView result7(@RequestParam("infMarital") Integer infMarital,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Information> infMaritalList = infoService.findByInfMarital(infMarital);
        try {
            List<Information> information3 = infoService.findByInfMarital(infMarital);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/info/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesSexList.size());
        if (infMaritalList.size()==0){
            map.put("url", contextPath + "/personnel/info/search1");
            return new ModelAndView("common/error5", map);
        }
        map.put("infMaritalList", infMaritalList);
        return new ModelAndView("info/result7", map);
    }
}
