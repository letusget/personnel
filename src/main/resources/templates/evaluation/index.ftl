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

                        <div class="form-group">
                            <label>员工姓名</label><input type="text" class="form-control" id="empName"
                                                      name="empName" value="${(evaluation.empName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>旷工天数</label><input type="int" class="form-control" id="evaAbsence" placeholder="旷工每天每次绩效扣20分"
                                                      name="evaAbsence" value="${(evaluation.evaAbsence)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>出勤天数</label><input type="int" class="form-control" id="evaAttendance" placeholder="天数，满勤为22天"
                                                      name="evaAttendance" value="${(evaluation.evaAttendance)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>迟到次数</label><input type="text" class="form-control" id="evaLate" placeholder="迟到每人每天绩效扣5分"
                                                      name="evaLate" value="${(evaluation.evaLate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>请假天数</label><input type="int" class="form-control" id="evaVacate" placeholder="每月请假三天内不影响绩效，三天以上无端请假每天每次绩效扣5分"
                                                      name="evaVacate" value="${(evaluation.evaVacate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>加班工时</label><input type="int" class="form-control" id="evaOvertime" placeholder="加班每小时绩效加1分"
                                                      name="evaOvertime" value="${(evaluation.evaOvertime)!''}"/>
                        </div>
                        <#--
                        <div class="form-group">
                            <label>员工评级</label>
                           <select type="text" class="form-control" id="evaLevel" name="evaLevel" placeholder="A(优) B(良) C(中) D(差) E(极差，业务能力不达标）"
                                   value="${(evaluation.evaLevel)!''}">
                               <option style="display: none">请在下面选择目前的政治面貌</option>
                               <option value="A">优秀</option>
                               <option value="B">良好</option>
                               <option value="C">中等</option>
                               <option value="D">较差</option>
                               <option value="E">极差</option>
                           </select>
                            <input type="text" class="form-control" id="evaLevel" name="evaLevel" placeholder="A(优) B(良) C(中) D(差)"
                                   value="${(evaluation.evaLevel)!''}"/>
                        </div>
                        -->
                        <#--<div class="form-group">
                            <label>加班工时</label><input type="text" class="form-control" id="evaOvertime" placeholder="按小时计算"
                                                      name="evaOvertime" value="${(evaluation.evaOvertime)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工备注</label><input type="text" class="form-control" id="evaRemarks" name="evaRemarks" value="${(evaluation.evaRemarks)!''}"/>
                        </div>-->

                        <button type="submit" class="btn btn-default">提交结果</button>
                        <input  type="hidden" name="evaId" value="${(evaluation.evaId)!''}">
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