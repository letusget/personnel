<#--
<html>
&lt;#&ndash;引入头文件&ndash;&gt;
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">
    &lt;#&ndash;边栏sidebar&ndash;&gt;
    <#include "../common/nav.ftl">
    &lt;#&ndash;主要内容 content start&ndash;&gt;
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    &lt;#&ndash;主要内容 content start&ndash;&gt;
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>序号</th>
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
                        </tr>
                        </thead>
                        <tbody>
                        <#list salariesPageList.content as salaries>
                            <tr>
                                <td>${salaries_index+1}</td>
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
                                &lt;#&ndash;<td><a href="/personnel/salaries/delete?empId=${salaries.empId}">删除</a></td>&ndash;&gt;
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    &lt;#&ndash;主要内容 content end&ndash;&gt;
                </div>
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
                                <a href="/personnel/salaries/list?page=${currentPage - 1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        &lt;#&ndash;上一页处理 end&ndash;&gt;
                        &lt;#&ndash;代循环遍历(根据DB中查询出来的带分页查询所有订单列表)&ndash;&gt;
                        <#list 1..salariesPageList.getTotalPages() as index>
                        &lt;#&ndash;当前页面置灰&ndash;&gt;
                            <#if currentPage == index>
                                <li class="disabled">
                                    <a href="/personnel/salaries/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/personnel/salaries/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            </#if>
                        </#list>
                        &lt;#&ndash;代循环遍历(根据DB中查询出来的带分页查询所有订单列表)&ndash;&gt;
                        &lt;#&ndash; 下一页处理 start&ndash;&gt;
                        <#if currentPage gte salariesPageList.getTotalPages()>
                            <li>
                                <a href="#">下一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/salaries/list?page=${currentPage + 1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        &lt;#&ndash; 下一页处理 end&ndash;&gt;
                    </ul>
                </div>
                &lt;#&ndash;分页 end&ndash;&gt;
            </div>
        </div>
    </div>
    &lt;#&ndash;主要内容 content start&ndash;&gt;
</div>
</body>
</html>-->
