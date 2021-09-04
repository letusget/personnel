<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
    <!-- (2)自己写的div start -->
    <div id="wrapper" class="toggled">

        <#-- (3)边栏sidebar-->
        <#include  "../common/nav.ftl">

        <!-- (4) 主要内容content start -->
        <div class="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <!--  复制 从 http://www.ibootstrap.cn 里面下载的内容 start -->
                    <div class="col-md-12 column">
                        <#--显示系统时间-->
                        <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                        <form role="form" method="post" action="/personnel/employees/save">

                            <div class="form-group">
                                <label>员工照片</label>
                                <img height="100px;" width="100px;" src="${(employee.empPhoto)!''}" alt="该图片不存在!"/> <br/>
                                <input id="productIcon" name="productIcon" type="text"  value="${(employee.empPhoto)!''}" width="50%"/>
                            </div>

                            <div class="form-group">
                                <label>员工姓名</label>
                                <input type="text" class="form-control" id="productPrice" name="productPrice" value="${(employee.empName)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工性别</label><input type="number" class="form-control" id="productStock" name="productStock" value="${(employee.empSex)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工邮箱</label><input type="text" class="form-control" id="productDescription" name="productDescription" value="${(employee.empEmail)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工手机号码</label><input type="text" class="form-control" id="productName" name="productName" value="${(employee.empPhone)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工部门</label><input type="text" class="form-control" id="productName" name="productName" value="${(employee.depName)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工身份证号码</label><input type="text" class="form-control" id="productName" name="productName" value="${(employee.empIdCard)!''}"/>
                            </div>
                            <#--
                            <div class="form-group">
                                <label>员工入职时间</label><input type="text" class="form-control" id="productName" name="productName" value="${(employee.empEntry)!''}"/>
                            </div>
                            -->
                            <div class="form-group">
                                <label>员工婚姻状态</label><input type="text" class="form-control" id="productName" name="productName" value="${(employee.empMarital)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工备注</label><input type="text" class="form-control" id="productName" name="productName" value="${(employee.empRemarks)!''}"/>
                            </div>

                            <div class="form-group">

                                <label>部门规划</label>
                                <select name="categoryType" id="categoryType" class="form-control">
                                    <#--部门信息-->
                                   <#-- <#list categoryList as category>
                                        <option value="${category.categoryType}" <#if (product.categoryType)?? && product.categoryType == category.categoryType> selected </#if> >
                                            ${category.categoryName}
                                        </option>
                                    </#list>-->
                                </select>
                            </div>
                            <button type="submit" class="btn btn-default">提交结果</button>
                            <input  type="hidden" name="productId" value="${(employee.empId)!''}">
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
