<html>
<#--引入头文件-->
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/navEmployee.ftl">
    <#--主要内容 content start-->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <#--显示系统时间-->
                    <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                    <#--主要内容 content start-->
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>员工编号</th>
                            <th>员工姓名</th>
                            <th>学历</th>
                            <th>政治面貌</th>
                            <th>入职时间</th>
                            <th>籍贯</th>
                            <th>婚姻状况</th>
                            <th>备注</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list infoPageList.content as info>
                            <tr>
                                <td>${info_index+1}</td>
                                <td>${info.empId}</td>
                                <td>${info.empName}</td>
                                <td>${info.infEducation}</td>
                                <td>${info.getInfPoliticalEnum().message}</td>
                                <td>${info.infEntry}</td>
                                <td>${info.infPlace}</td>
                                <td>${info.getInfMaritalEnum().message}</td>
                                <td>${info.infRemarks}</td>
                                <td><a href="/personnel/info/index?infId=${info.infId}">修改</a></td>
                                <#--<td><a href="/personnel/info/delete?infId=${info.infId}">删除</a></td>-->
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <#--主要内容 content end-->
                </div>
<#--
                &lt;#&ndash;分页 start&ndash;&gt;
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">  &lt;#&ndash;让分页居右&ndash;&gt;
                        &lt;#&ndash;上一页处理 start&ndash;&gt;
                        <#if currentPage lte 1>
                            <li>
                                <a href="#">上一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/info/list?page=${currentPage - 1}&size=${size}">下一页</a>
                            </li>
                        </#if>
                        &lt;#&ndash;上一页处理 end&ndash;&gt;
                        &lt;#&ndash;代循环遍历(根据DB中查询出来的带分页查询所有订单列表)&ndash;&gt;
                        <#list 1..infoPageList.getTotalPages() as index>
                        &lt;#&ndash;当前页面置灰&ndash;&gt;
                            <#if currentPage == index>
                                <li class="disabled">
                                    <a href="/personnel/info/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/personnel/info/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            </#if>
                        </#list>
                        &lt;#&ndash;代循环遍历(根据DB中查询出来的带分页查询所有订单列表)&ndash;&gt;
                        &lt;#&ndash; 下一页处理 start&ndash;&gt;
                        <#if currentPage gte infoPageList.getTotalPages()>
                            <li>
                                <a href="#">下一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/info/list?page=${currentPage + 1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        &lt;#&ndash; 下一页处理 end&ndash;&gt;
                    </ul>
                </div>
                &lt;#&ndash;分页 end&ndash;&gt;
               -->
            </div>
        </div>
    </div>
    <#--主要内容 content start-->
</div>
</body>
</html>