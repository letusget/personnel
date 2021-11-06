package com.lll.controller;

import com.lll.DTO.EmployeesDTO;
import com.lll.entity.Departments;
import com.lll.entity.Employees;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.form.EmployeeForm;
import com.lll.service.DepartmentsService;
import com.lll.service.EmployeesService;
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

import javax.persistence.criteria.From;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 员工信息
 * http://192.168.1.3:8080/personnel/employees/list
 */
@Controller
@RequestMapping("/employees")
@Slf4j
public class EmployeesController {
    //员工 Service
    @Autowired
    private EmployeesService employeesService;

    //部门Service
    @Autowired
    private DepartmentsService departmentsService;

    /**
     * 员工列表
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "4") Integer size,
                             Map<String, Object> map) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        //分页查询员工列表
        Page<Employees> employeesPageList = employeesService.findAll(pageRequest);

        //设置员工分页列表
        map.put("employeesPageList", employeesPageList);
        //设置当前页
        map.put("currentPage", page);
        //设置每页显示多少条数据
        map.put("pageSize", size);

        return new ModelAndView("employees/list", map);

    }

    @GetMapping("/list1")
    public ModelAndView list1(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "4") Integer size,
                             Map<String, Object> map) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        //分页查询员工列表
        Page<Employees> employeesPageList = employeesService.findAll(pageRequest);

        //设置员工分页列表
        map.put("employeesPageList", employeesPageList);
        //设置当前页
        map.put("currentPage", page);
        //设置每页显示多少条数据
        map.put("pageSize", size);

        return new ModelAndView("employees/list1", map);

    }

    @GetMapping("/list2")
    public ModelAndView list2(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "size", defaultValue = "4") Integer size,
                              Map<String, Object> map) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        //分页查询员工列表
        Page<Employees> employeesPageList = employeesService.findAll(pageRequest);
        List<Employees> employeesList=employeesService.findUpAll("夏海藻");

        //设置员工分页列表
        map.put("employeesPageList", employeesPageList);
        //设置当前页
        map.put("currentPage", page);
        //设置每页显示多少条数据
        map.put("pageSize", size);

        return new ModelAndView("employees/list2", map);

    }

    /**
     * 修改和新增员工使用同一个页面
     * 区别是在修改时是有 员工ID的
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "empId", required = false) String empId, Map<String, Object> map) {
        if (empId != null)
        //if (StringUtils.hasText(empId))
        {
            //根据员工id 查询员工信息
            Employees employees = employeesService.findByEmpId(empId);
            //设置员工信息
            map.put("employees", employees);
        }
        //查询部门信息

        List<Departments> departmentsList = departmentsService.findAll();
        map.put("departmentsList", departmentsList);

        /*return new ModelAndView("employees/index",map);*/
        return new ModelAndView("employees/index", map);

    }
    @GetMapping("/index1")
    public ModelAndView index1(@RequestParam(value = "empId", required = false) String empId, Map<String, Object> map) {
        if (empId != null)
        //if (StringUtils.hasText(empId))
        {
            //根据员工id 查询员工信息
            Employees employees = employeesService.findByEmpId(empId);
            //设置员工信息
            map.put("employees", employees);
        }
        //查询部门信息

        List<Departments> departmentsList = departmentsService.findAll();
        map.put("departmentsList", departmentsList);

        /*return new ModelAndView("employees/index",map);*/
        return new ModelAndView("employees/index1", map);

    }
    @GetMapping("/index2")
    public ModelAndView index2(@RequestParam(value = "empId", required = false) String empId, Map<String, Object> map) {
        if (empId != null)
        //if (StringUtils.hasText(empId))
        {
            //根据员工id 查询员工信息
            Employees employees = employeesService.findByEmpId(empId);
            //设置员工信息
            map.put("employees", employees);
        }
        //查询部门信息

        List<Departments> departmentsList = departmentsService.findAll();
        map.put("departmentsList", departmentsList);

        /*return new ModelAndView("employees/index",map);*/
        return new ModelAndView("employees/index2", map);

    }


    /**
     * 新增员工
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid EmployeeForm form, BindingResult bindingResult, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (bindingResult.hasErrors()) {
            session.setAttribute("msg", bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url", request.getContextPath() + "/employees/index");
            return new ModelAndView("common/error");
        }
        Employees employees = new Employees();
        try {
            //如果empId 有值，则说明是修改
            if (StringUtils.hasText(form.getEmpId())) {
                employees = employeesService.findByEmpId(form.getEmpId());
            } else
            {
                form.setEmpId(KeyUtil.genUniqueKey());
            }
            //将form 中的对象 copy 给employees
            BeanUtils.copyProperties(form, employees);
            //保存 员工信息
            employeesService.save(employees);
        } catch (PersonnelException e) {
            session.setAttribute("msg", e.getMessage());
            session.setAttribute("url", request.getContextPath() + "/employees/index");
            return new ModelAndView("common/error");
        }
        session.setAttribute("msg", ResultEnum.EMPLOYEE_SUCCESS.getMessage());
        session.setAttribute("url", request.getContextPath() + "/employees/list");
        return new ModelAndView("common/success");

    }
    @PostMapping("/save1")
    public ModelAndView save1(@Valid EmployeeForm form, BindingResult bindingResult, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (bindingResult.hasErrors()) {
            session.setAttribute("msg", bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url", request.getContextPath() + "/employees/index1");
            return new ModelAndView("common/error");
        }
        Employees employees = new Employees();
        try {
            //如果empId 有值，则说明是修改
            if (StringUtils.hasText(form.getEmpId())) {
                employees = employeesService.findByEmpId(form.getEmpId());
            } else
            {
                form.setEmpId(KeyUtil.genUniqueKey());
            }
            //将form 中的对象 copy 给employees
            BeanUtils.copyProperties(form, employees);
            //保存 员工信息
            employeesService.save(employees);
        } catch (PersonnelException e) {
            session.setAttribute("msg", e.getMessage());
            session.setAttribute("url", request.getContextPath() + "/employees/index1");
            return new ModelAndView("common/error");
        }
        session.setAttribute("msg", ResultEnum.EMPLOYEE_SUCCESS.getMessage());
        session.setAttribute("url", request.getContextPath() + "/employees/list1");
        return new ModelAndView("common/success");

    }
    @PostMapping("/save2")
    public ModelAndView save2(@Valid EmployeeForm form, BindingResult bindingResult, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (bindingResult.hasErrors()) {
            session.setAttribute("msg", bindingResult.getFieldError().getDefaultMessage());
            session.setAttribute("url", request.getContextPath() + "/employees/index2");
            return new ModelAndView("common/error");
        }
        Employees employees = new Employees();
        try {
            //如果empId 有值，则说明是修改
            if (StringUtils.hasText(form.getEmpId())) {
                employees = employeesService.findByEmpId(form.getEmpId());
            } else
            {
                form.setEmpId(KeyUtil.genUniqueKey());
            }
            //将form 中的对象 copy 给employees
            BeanUtils.copyProperties(form, employees);
            //保存 员工信息
            employeesService.save(employees);
        } catch (PersonnelException e) {
            session.setAttribute("msg", e.getMessage());
            session.setAttribute("url", request.getContextPath() + "/employees/index2");
            return new ModelAndView("common/error");
        }
        session.setAttribute("msg", ResultEnum.EMPLOYEE_SUCCESS.getMessage());
        session.setAttribute("url", request.getContextPath() + "/employees/list2");
        return new ModelAndView("common/success");

    }

/*    @PostMapping("/save")
    public ModelAndView save(@Valid EmployeeForm form, BindingResult bindingResult, Map<String,Object> map)
    {
        if (bindingResult.hasErrors())
        {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/personnel/employees/index");
            return new ModelAndView("common/error",map);
        }

        Employees employees=new Employees();
        try
        {
            if (form.getEmpId()!=null)
            {
                employees=employeesService.findByEmpId(form.getEmpId());
            }
            else
            {
            //这里会报错：target must not be null,我努力尝试，这里的问题是form 中为空，导致的，具体就是form中的empId 属性为空导致的，在
            //调试时，即使 empId 属性为空，判断为新增是，也不会进行 setEmpID 操作，就导致form中有一个空字段，出现这个错误
            //目前我无法解决这个问题，感觉是底层哪里的问题，所以就索性使用HttpServletRequest重新写了一遍代码
                form.setEmpId(KeyUtil.genUniqueKey());
                String getEmpId=form.getEmpId();
                System.out.println(getEmpId);
            }
            BeanUtils.copyProperties(form,employees);
            employeesService.save(employees);

        }catch (PersonnelException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/personnel/employees/index");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.EMPLOYEE_SUCCESS.getMessage());
        map.put("url","/personnel/employees/list");
        return new ModelAndView("common/success",map);

    }*/

    /**
     * 删除员工极其相关所有信息
     *
     * @param empId
     * @param map
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("empId") String empId, Map<String, Object> map) {
        try {
            employeesService.delete(empId);
        } catch (PersonnelException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/personnel/employees/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.EMPLOYEE_SUCCESS.getMessage());
        map.put("url", "/personnel/employees/list");
        return new ModelAndView("common/success", map);
    }
    @GetMapping("/delete1")
    public ModelAndView delete1(@RequestParam("empId") String empId, Map<String, Object> map) {
        try {
            employeesService.delete(empId);
        } catch (PersonnelException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/personnel/employees/list1");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.EMPLOYEE_SUCCESS.getMessage());
        map.put("url", "/personnel/employees/list1");
        return new ModelAndView("common/success", map);
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam(value = "empName", required = false) String empName,
                               @RequestParam(value = "depName", required = false) String depName,
                               @RequestParam(value = "empSex", required = false) Integer empSex,
                               Map<String, Object> map) {

        if (empName != null && depName != null && empSex != null) {

        }
        List<Departments> departmentsList = departmentsService.findAll();
        map.put("departmentsList", departmentsList);
        return new ModelAndView("employees/search", map);
    }

    @GetMapping("/search1")
    public ModelAndView search1(@RequestParam(value = "empName", required = false) String empName,
                                @RequestParam(value = "depName", required = false) String depName,
                                @RequestParam(value = "empSex", required = false) Integer empSex,
                                Map<String, Object> map) {
        if (empName != null && depName != null && empSex != null) {

        }
        List<Departments> departmentsList = departmentsService.findAll();
        map.put("departmentsList", departmentsList);
        return new ModelAndView("employees/search1", map);
    }


    @GetMapping("/result")
    public ModelAndView result(@RequestParam("empName") String empName,
                               Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        EmployeesDTO employeesDTO = new EmployeesDTO();
        try {
            employeesDTO = employeesService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/employees/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }

        map.put("employees", employeesDTO);
        return new ModelAndView("employees/result", map);
    }

    @GetMapping("/result2")
    public ModelAndView result2(@RequestParam("depName") String depName,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Employees> employeesList = employeesService.findByDepName(depName);
        try {
            List<Employees> employees1 = employeesService.findByDepName(depName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/employees/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesList.size());
        if (employeesList.size()==0){
            map.put("url", contextPath + "/personnel/employees/search");
            return new ModelAndView("common/error1", map);
        }
        map.put("employeesList", employeesList);
        return new ModelAndView("employees/result2", map);
    }

    @GetMapping("/result3")
    public ModelAndView result3(@RequestParam("empSex") Integer empSex,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Employees> employeesSexList = employeesService.findByEmpSex(empSex);
        try {
            List<Employees> employees2 = employeesService.findByEmpSex(empSex);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/employees/search");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesSexList.size());
        if (employeesSexList.size()==0){
            map.put("url", contextPath + "/personnel/employees/search");
            return new ModelAndView("common/error2", map);
        }
        map.put("employeesSexList", employeesSexList);
        return new ModelAndView("employees/result3", map);
    }


    @GetMapping("/result1")
    public ModelAndView result1(@RequestParam("empName") String empName, Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        EmployeesDTO employeesDTO = new EmployeesDTO();
        try {
            employeesDTO = employeesService.findByEmpName(empName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/employees/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        map.put("employees", employeesDTO);
        return new ModelAndView("employees/result1", map);
    }

    @GetMapping("/result4")
    public ModelAndView result4(@RequestParam("depName") String depName,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Employees> employeesList = employeesService.findByDepName(depName);
        try {
            List<Employees> employees1 = employeesService.findByDepName(depName);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/employees/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesList.size());
        if (employeesList.size()==0){
            map.put("url", contextPath + "/personnel/employees/search1");
            return new ModelAndView("common/error1", map);
        }
        map.put("employeesList", employeesList);
        return new ModelAndView("employees/result4", map);
    }

    @GetMapping("/result5")
    public ModelAndView result5(@RequestParam("empSex") Integer empSex,
                                Map<String, Object> map, HttpServletRequest request) {
        String contextPath = "";
        List<Employees> employeesSexList = employeesService.findByEmpSex(empSex);
        try {
            List<Employees> employees2 = employeesService.findByEmpSex(empSex);
        } catch (Exception e) {
            log.error("发生异常{}", e);
            contextPath = request.getContextPath(); // 灵活获取应用名 如/personnel
            map.put("url", contextPath + "/employees/search1");
            map.put("msg", e.getMessage());
            // return new ModelAndView("common/no_order_detail_error", map);
            return new ModelAndView("common/error", map);
        }
        //System.out.println(employeesSexList.size());
        if (employeesSexList.size()==0){
            map.put("url", contextPath + "/personnel/employees/search");
            return new ModelAndView("common/error2", map);
        }
        map.put("employeesSexList", employeesSexList);
        return new ModelAndView("employees/result5", map);
    }
}
