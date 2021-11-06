<html>

<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
<!-- (2)复制  -->
<!-- 自己写的div start -->
<div id="wrapper" class="toggled">

    <#-- (3)边栏sidebar-->
    <#include  "../common/nav.ftl">
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
                        <th>员工编号</th>
                        <th>员工姓名</th>
                        <th>学历</th>
                        <th>政治面貌</th>
                        <th>入职时间</th>
                        <th>籍贯</th>
                        <th>婚姻状况</th>
                        <th>备注</th>
                        <th colspan="2">操作</th>
                        </thead>
                        <#list informationList as info>
                        <tbody>
                        <tr>
                            <td>${info.infId}</td>
                            <td>${info.empName}</td>
                            <td>${info.infEducation}</td>
                            <td>${info.getInfPoliticalEnum().message}</td>
                            <td>${info.infEntry}</td>
                            <td>${info.infPlace}</td>
                            <td>${info.getInfMaritalEnum().message}</td>
                            <td>${info.infRemarks}</td>
                            <td><a href="/personnel/info/index?infId=${info.infId}">修改</a></td>
                            <td><a href="/personnel/info/delete?infId=${info.infId}">删除</a></td>
                        </tr>
                        </tbody>
                        </#list>
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
