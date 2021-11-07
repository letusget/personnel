<html>

<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
<!-- (2)复制  -->
<!-- 自己写的div start -->
<div id="wrapper" class="toggled">

    <#-- (3)边栏sidebar-->
    <#include  "../common/navManager.ftl">
    <!-- (4) 主要内容content start -->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <#--显示系统时间-->
                <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                <!-- 表格内容 start  -->
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <#--<th>序号</th>-->
                        <th>员工姓名</th>
                        <th>员工旷工</th>
                        <th>员工出勤</th>
                        <th>员工迟到</th>
                        <th>员工请假</th>
                        <th>加班工时</th>
                        <th>员工评级</th>
                        <th>员工备注</th>

                        <th colspan="2">操作</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${evaluation.empName}</td>
                            <td>${evaluation.evaAbsence}</td>
                            <td>${evaluation.evaAttendance}</td>
                            <td>${evaluation.evaLate}</td>
                            <td>${evaluation.evaVacate}</td>
                            <td>${evaluation.evaOvertime}</td>
                            <td>${evaluation.evaLevel}</td>
                            <td>${evaluation.evaRemarks}</td>

                            <td><a href="/personnel/evaluation/index1?evaId=${evaluation.evaId}">修改</a></td>
                            <#--<td><a href="/personnel/evaluation/delete?empId=${evaluation.empId}">删除</a></td>-->
                        </tr>
                        </tbody>
                        <#--主要内容content end -->
                    </table>
                </div>
                <!-- 表格内容 end  -->


            </div>
        </div>
    </div>
    <!-- (4) 主要内容content end -->
</div>
<!-- (2)自己写的div end -->
</body>
</html>