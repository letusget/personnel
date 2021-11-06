<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
<!-- (2)自己写的div start -->
<div id="wrapper" class="toggled">

    <#-- (3)边栏sidebar-->
    <#include  "../common/navManager.ftl">

    <!-- (4) 主要内容content start -->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <!--  复制 从 http://www.ibootstrap.cn 里面下载的内容 start -->
                <div class="col-md-12 column">
                    <#--显示系统时间-->
                    <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                    <form role="form" method="get" action="/personnel/employees/result1?empName=empName">
                        <div class="form-group">
                            <label>输入员工姓名</label>
                            <input type="text" class="form-control" id="productPrice" name="empName"/>
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>

                    <form role="form" method="get" action="/personnel/employees/result4?depName=depName">
                        <div class="form-group">
                            <label>输入部门名称</label>
                            <#-- <input type="text" class="form-control" id="productPrice" name="depName"/>-->
                            <select name="depName" id="categoryType" class="form-control">
                                <#--部门信息-->
                                <#list departmentsList as departments>
                                    <option value="${departments.depName}"
                                            <#if (employees.depName)?? && employees.depName == departments.depName> selected </#if> >
                                        ${departments.depName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-default" >搜索</button>
                    </form>

                    <form role="form" method="get" action="/personnel/employees/result5?empSex=empSex">
                        <div class="form-group">
                            <label>输入员工性别</label>
                            <#-- <input type="text" class="form-control" id="productPrice" name="depName"/>-->
                            <select class="form-control" id="empSex" onclick="onClickSex()" name="empSex" placeholder="0 为女性，1 为男性"
                                    value="${(employees.empSex)!''}">
                                <option style="display: none">请在下面选择性别</option>
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-default" >搜索</button>
                    </form>

                </div>
                <!--  复制 从 http://www.ibootstrap.cn 里面下载的内容 end -->


            </div>
        </div>
    </div>
    <!-- (4) 主要内容content end -->

</div>
<!-- (2)自己写的div end -->
</body>
</html>
