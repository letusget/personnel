<html>

<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
<!-- (2)复制  -->
<!-- 自己写的div start -->
<div id="wrapper" class="toggled">

    <#-- (3)边栏sidebar-->
    <#include  "../common/navEmployee.ftl">
    <!-- (4) 主要内容content start -->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <#--显示系统时间-->
                <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                <!-- 表格内容 start  -->
                <h3>基本信息</h3>
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>

                        <th>员工ID</th>
                        <th>员工出勤</th>
                        <th>员工姓名</th>
                        <th>员工性别</th>
                        <th>员工邮箱</th>
                        <th>员工手机号码</th>
                        <#-- <th>员工部门编号</th>-->
                        <th>员工部门</th>
                        <th>员工身份证号码</th>
                        <th>员工备注</th>

                       <#-- <th colspan="2">操作</th>-->
                        </thead>

                        <tbody>

                                <tr>
                                    <td>${employeesDTO.empId}</td>
                                    <#--<td>${employees.empId}</td>-->
                                    <td><img height="100" width="100" src="${employeesDTO.empPhoto}" alt="该图片不存在!"></td>

                                    <td>${employeesDTO.empName}</td>
                                    <td>${employeesDTO.getEmpSexEnum().message}</td>
                                    <td>${employeesDTO.empEmail}</td>
                                    <td>${employeesDTO.empPhone}</td>
                                    <td>${employeesDTO.depName}</td>
                                    <td>${employeesDTO.empIdCard}</td>
                                    <td>${employeesDTO.empRemarks}</td>

                                    <#--<td><a href="/personnel/employees/index?empId=${employeesDTO.empId}">修改</a></td>-->
                                    <#--<td><a href="/personnel/employees/delete?empId=${employees.empId}">删除</a></td>-->
                                </tr>

                        </tbody>

                        <#--主要内容content end -->
                    </table>
                </div>
                <!-- 表格内容 end  -->

                    <img height="10%" width="100%" src="https://tva2.sinaimg.cn/large/006x3t5Xgy1gw4ly8ai2gg30u005kq3c.gif">

                <h3>背景信息</h3>
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <#--<th>序号</th>-->
                       <#-- <th>编号</th>
                        <th>姓名</th>-->
                        <th>学历</th>
                        <th>政治面貌</th>
                        <th>籍贯</th>
                        <th>婚姻状况</th>
                        <th>备注</th>
                        <#-- <th>员工入职时间</th>


                       <#-- <th colspan="2">操作</th>-->
                        </thead>

                        <tbody>
                        <tr>
                            <#--<td>${informationDTO.infId}</td>
                            <td>${informationDTO.empName}</td>-->
                            <td>${informationDTO.infEducation}</td>
                            <td>${informationDTO.getInfPoliticalEnum().message}</td>
                            <td>${informationDTO.infPlace}</td>
                            <td>${informationDTO.getInfMaritalEnum().message}</td>

                            <td>${informationDTO.infRemarks}</td>

                           <#-- <td><a href="/personnel/employees/index?empId=${informationDTO.empId}">修改</a></td>-->
                        </tr>
                        </tbody>

                        <#--主要内容content end -->
                    </table>
                </div>

                <img height="10%" width="100%" src="https://tvax4.sinaimg.cn/large/006x3t5Xgy1gw4lzb7svig30u005k3zf.gif">

                <h3>评价信息</h3>
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>

                        <th>旷工天数</th>
                        <th>出勤天数</th>
                        <th>迟到次数</th>
                        <th>加班工时</th>
                        <th>本月评级</th>
                        <th>备注信息</th>

                        <#-- <th colspan="2">操作</th>-->
                        </thead>

                        <tbody>
                        <tr>
                            <td>${evaluationDTO.evaAbsence}</td>
                            <td>${evaluationDTO.evaAttendance}</td>
                            <td>${evaluationDTO.evaLate}</td>
                            <td>${evaluationDTO.evaOvertime}</td>
                            <td>${evaluationDTO.evaLevel}</td>
                            <td>${evaluationDTO.evaRemarks}</td>

                            <#-- <td><a href="/personnel/employees/index?empId=${informationDTO.empId}">修改</a></td>-->
                        </tr>
                        </tbody>

                        <#--主要内容content end -->
                    </table>
                </div>

                <img height="30%" width="100%" src="https://tva3.sinaimg.cn/large/006x3t5Xgy1gw4ly1zyg5g30ku04kgs6.gif">


            </div>
        </div>
    </div>
    <!-- (4) 主要内容content end -->
</div>
<!-- (2)自己写的div end -->
</body>
</html>
