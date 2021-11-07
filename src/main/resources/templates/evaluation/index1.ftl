<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<script type="text/javascript">
    function onClickId()
    {
        alert("员工ID 属性由系统自动确定，不可手动修改");
    }

    function onClickAbsence()
    {
        var empNameText=document.getElementById("empName").value;

        if (!empNameText)
        {
            alert("员工姓名不可为空，不建议修改");

        }
    }

    function onClickAttendance()
    {
        var absence=document.getElementById("evaAbsence");
        var absenceText=absence.value;
        if (!absenceText)
        {
            alert("该字段不可为空，无旷工记录则为0");

        }
        //验证正整数
        var patt=/^\d+$/;
        if (!patt.test(absenceText))
        {
            alert(absenceText+ "输入数据不合要求，请修改");
        }
    }

    function onClickLate()
    {
        var evaAttendance=document.getElementById("evaAttendance");
        var evaAttendanceText=evaAttendance.value;
        if (!evaAttendanceText)
        {
            alert("该字段不可为空，满勤为22天");

        }
        //验证正整数
        var patt=/^\d+$/;
        if (!patt.test(evaAttendanceText))
        {
            alert(evaAttendanceText+ "输入数据不合要求，请修改");
        }

    }

    function onClickVacate()
    {

        var evaLate=document.getElementById("evaLate").value;
        if (!evaLate)
        {
            alert("该字段不可为空");

        }
        //验证正整数
        var patt=/^\d+$/;
        if (!patt.test(evaLate))
        {
            alert(evaLate+ "输入数据不合要求，请修改");
        }
    }

    function onClickOvertime()
    {

        var evaVacate=document.getElementById("evaVacate").value;
        if (!evaVacate)
        {
            alert("该字段不可为空");

        }
        //验证正整数
        var patt=/^\d+$/;
        if (!patt.test(evaVacate))
        {
            alert(evaVacate+ "输入数据不合要求，请修改");
        }
    }

    function onClickLevel()
    {
        alert("员工评级由系统根据以上数据分析计算得出，不可手动修改");
        var evaOvertime=document.getElementById("evaOvertime").value;
        if (!evaOvertime)
        {
            alert("该字段不可为空");

        }
        //验证正整数
        var patt=/^\d+$/;
        if (!patt.test(evaOvertime))
        {
            alert(evaOvertime+ "输入数据不合要求，请修改");
        }
    }

    function onClickRemarks()
    {
        var evaOvertime=document.getElementById("evaOvertime").value;
        if (!evaOvertime)
        {
            alert("该字段不可为空");

        }
        //验证正整数
        var patt=/^\d+$/;
        if (!patt.test(evaOvertime))
        {
            alert(evaOvertime+ "输入数据不合要求，请修改");
        }
    }

    function onsubmitFun()
    {
        var evaVacate=document.getElementById("evaVacate").value;
        var evaLate=document.getElementById("evaLate").value;
        var evaAttendance=document.getElementById("evaAttendance");
        var absence=document.getElementById("evaAbsence").value;
        var empNameText=document.getElementById("empName").value;
        var evaOvertime=document.getElementById("evaOvertime").value;

        if (!evaOvertime||!empNameText||!absence||!evaAttendance||!evaLate||!evaVacate)
        {
            alert("信息填写未完成，请检查输入信息！");
            return false;
        }
        return true;

    }

</script>

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
                    <form role="form" method="post" action="/personnel/evaluation/save1">

                        <div class="form-group">
                            <label>员工姓名</label><input type="text" class="form-control" id="empName"
                                                      name="empName" value="${(evaluation.empName)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>员工id</label><input type="text" readonly unselectable="on"class="form-control" id="empId" onclick="onClickId()"
                                                      name="empId" value="${(evaluation.empId)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>旷工天数</label><input type="int" class="form-control" id="evaAbsence" placeholder="旷工每天每次绩效扣20分"
                                                      onclick="onClickAbsence()" name="evaAbsence" value="${(evaluation.evaAbsence)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>出勤天数</label><input type="int" class="form-control" id="evaAttendance" placeholder="天数，满勤为22天"
                                                      onclick="onClickAttendance()" name="evaAttendance" value="${(evaluation.evaAttendance)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>迟到次数</label><input type="text" class="form-control" id="evaLate" placeholder="迟到每人每天绩效扣5分"
                                                      onclick="onClickLate()" name="evaLate" value="${(evaluation.evaLate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>请假天数</label><input type="int" class="form-control" id="evaVacate" placeholder="每月请假三天内不影响绩效，三天以上无端请假每天每次绩效扣5分"
                                                      onclick="onClickVacate()" name="evaVacate" value="${(evaluation.evaVacate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>加班工时</label><input type="int" class="form-control" id="evaOvertime" placeholder="加班每小时绩效加1分"
                                                      onclick="onClickOvertime()" name="evaOvertime" value="${(evaluation.evaOvertime)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>员工评级</label>
                            <#--<select type="text" class="form-control" id="evaLevel" name="evaLevel" placeholder="员工评级由以上数据计算得出，不可手动修改"
                                    onclick="onClickLevel()" value="${(evaluation.evaLevel.value())!''}">
                                &lt;#&ndash;<option style="display: none">员工评级由以上数据计算得出，不可手动修改</option>&ndash;&gt;
                                <option value="A" style="display: none">优秀</option>
                                <option value="B" style="display: none">良好</option>
                                <option value="C" style="display: none">中等</option>
                                <option value="D" style="display: none">较差</option>
                                <option value="E" style="display: none">极差</option>
                            </select>-->
                            <input type="text" readonly  unselectable="on"  class="form-control" id="evaLevel" name="evaLevel" placeholder="A(优) B(良) C(中) D(差)"
                                   onclick="onClickLevel()"  value="${(evaluation.evaLevel)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>备注</label><input type="int" class="form-control" id="evaRemarks"
                                                    name="evaRemarks" value="${(evaluation.evaRemarks)!''}"/>
                        </div>

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