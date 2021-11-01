<#--
<html>

&lt;#&ndash; (1) 引入头文件 &ndash;&gt;
<#include  "../common/header.ftl">

<body>
<!-- (2)复制  &ndash;&gt;
<!-- 自己写的div start &ndash;&gt;
<div id="wrapper" class="toggled">

    &lt;#&ndash; (3)边栏sidebar&ndash;&gt;
    <#include  "../common/nav.ftl">
    <!-- (4) 主要内容content start &ndash;&gt;
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                &lt;#&ndash;显示系统时间&ndash;&gt;
                <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                <!-- 表格内容 start  &ndash;&gt;
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <th>员工编号</th>
                        <th>员工姓名</th>
                        <th>基本金额</th>
                        <th>奖金金额</th>
                        <th>奖金描述</th>
                        <th>扣除金额</th>
                        <th>扣除描述</th>
                        <th>保险福利</th>
                        <th>最终金额</th>
                        <th>备注</th>
                        <th colspan="2">操作</th>
                        </thead>

                        <tbody>
                        <tr>
                            <td>${salaries.empId}</td>
                            <td>${salaries.empName}</td>
                            <td>${salaries.salBase}</td>
                            <td>${salaries.salBonus}</td>
                            <td>${salaries.salBonusDescribes}</td>
                            <td>${salaries.salFine}</td>
                            <td>${salaries.salFineDescribes}</td>
                            <td>${salaries.salBenefits}</td>
                            <td>${salaries.salFinal}</td>
                            <td>${salaries.salRemarks}</td>
                            <td><a href="/personnel/salaries/index?empId=${salaries.empId}">修改</a></td>
                            <td><a href="/personnel/salaries/delete?empId=${salaries.empId}">删除</a></td>
                        </tr>
                        </tbody>

                        &lt;#&ndash;主要内容content end &ndash;&gt;
                    </table>
                </div>
                <!-- 表格内容 end  &ndash;&gt;


            </div>
        </div>
    </div>
    <!-- (4) 主要内容content end &ndash;&gt;
</div>
<!-- (2)自己写的div end &ndash;&gt;
</body>
</html>
-->
