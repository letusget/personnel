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
                    <form role="form" method="post" action="/personnel/evaluation/save">
                        <!--
                        <div class="form-group">
                            <label>员工ID</label><input type="text" class="form-control" id="empId" name="empId" ''}"/>
                        </div>
                        -->
                        <div class="form-group">
                            <label>员工出勤</label><input type="text" class="form-control" id="evaAttendance" name="evaAttendance" value="${(evaluation.evaAttendance)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工迟到</label><input type="text" class="form-control" id="evaLate" name="evaLate" value="${(evaluation.evaLate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工评级</label><input type="text" class="form-control" id="evaLevel" name="evaLevel" value="${(evaluation.evaLevel)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>加班工时</label><input type="text" class="form-control" id="evaOvertime" name="evaOvertime" value="${(evaluation.evaOvertime)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工备注</label><input type="text" class="form-control" id="evaRemarks" name="evaRemarks" value="${(evaluation.evaRemarks)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">提交结果</button>
                        <input  type="hidden" name="empId" value="${(evaluation.empId)!''}">
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