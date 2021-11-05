<html>
<#include "../common/header.ftl">
<script type="text/javascript">

    function onClickEducation()
    {
        var empName=document.getElementById("empName");
        var empNameText=empName.value;
        if (!empNameText)
        {
            alert("员工姓名不能为空");

        }

        var patt=/^[\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*$/;
        if (!patt.test(empNameText))
        {
            //this.style.backgroundColor="red";
            alert(empNameText+" -> 此姓名输入不合规范，请输入真实姓名！");
        }
    }

    function onclickPolitical()
    {
        var empEducation=document.getElementById("empEducation").value;
        if (!empEducation)
        {
            alert("学历信息不能为空");

        }
    }

    function onClickEntry()
    {
        var empPolitical=document.getElementById("empPolitical").value;
        if (!empPolitical)
        {
            alert("政治面貌信息不能为空");

        }
        var patt=/^[0-4]*$/;
        if (!patt.test(empPolitical))
        {
            alert(empPolitical+" -> 政治面貌选择不合规范，请重新选择！");
        }
    }

    function onClickPlace()
    {
        var empEntry=document.getElementById("empEntry").value;
        if (!empEntry)
        {
            this.style.backgroundColor="red";
            alert("入职时间不能为空");

        }
    }



    function onClickMarry()
    {
        var empPlace=document.getElementById("empPlace").value;
        if (!empPlace)
        {
            alert("籍贯信息不能为空");

        }
    }

    function onClickRemarks()
    {
        var empMarry=document.getElementById("empMarry").value;
        if (!empMarry)
        {
            alert("婚姻状态不能为空");

        }

        var patt=/^[0-3]*$/;
        if (!patt.test(empMarry))
        {
            alert(empMarry+" -> 婚姻状态选择不合规范，请重新选择！");
        }

        var empPlace=document.getElementById("empPlace");
        var empPlaceText=empPlace.value;


    }

    function onsubmitFun()
    {
        var empMarry=document.getElementById("empMarry").value;
        var empPlace=document.getElementById("empPlace").value;
        var empEntry=document.getElementById("empEntry").value;
        var empPolitical=document.getElementById("empPolitical").value;
        var empEducation=document.getElementById("empEducation").value;
        var empName=document.getElementById("empName").value;

        if(!empMarry ||!empPlace||!empEntry||!empPolitical||!empEducation||!empName)
        {
            alert("信息填写未完成，请检查输入信息！");
            return false;
        }
        return true;

    }



</script>
<body>
<div id="wrapper" class="toggled">
    <#-- 边栏sidebar -->
    <#include "../common/navManager.ftl">

    <#-- 主要内容content start -->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <#--显示系统时间-->
                    <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>

                    <form role="form" method="post" action="/personnel/info/save1" onsubmit="return onsubmitFun()">
                        <div class="form-group">
                            <label>员工姓名</label>
                            <input name="empName" type="text" id="empName" class="form-control" value="${(information.empName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>学历</label>
                            <input name="infEducation" type="text" id="empEducation"
                                   onclick="onClickEducation()" class="form-control" value="${(information.infEducation)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>政治面貌</label>

                            <select name="infPolitical" type="text" id="empPolitical"
                                    onclick="onclickPolitical()" class="form-control" value="${(information.infPolitical)!''}">
                                <option style="display: none">请在下面选择目前的政治面貌</option>
                                <option value="0">共青团员</option>
                                <option value="1">党员</option>
                                <option value="2">无党派人士</option>
                                <option value="3">其他党派人士</option>
                                <option value="4">群众</option>
                            </select>

                            <#--<input name="infPolitical" type="text" id="empPolitical" onclick="onclickPolitical()" class="form-control" value="${(information.infPolitical)!''}"/>-->
                        </div>
                        <div class="form-group">
                            <label>入职时间</label>
                            <input name="infEntry" type="date" id="empEntry" onclick="onCliceEntry()" class="form-control" value="${(information.infEntry)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>籍贯</label>
                            <input name="infPlace" type="text" id="empPlace" onclick="onClickPlace()" class="form-control" value="${(information.infPlace)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>员工婚姻状态</label>

                            <select class="form-control" id="empMarry" onclick="onClickMarry()" name="empMarital" placeholder="0为未婚，1为已婚"
                                    value="${(information.infMarital)!''}">
                                <option style="display: none">请在下面选择目前的婚姻状态</option>
                                <option value="0">未婚</option>
                                <option value="1">已婚</option>
                                <option value="2">离异</option>
                                <option value="3">丧偶</option>
                            </select>

                            <#--<input type="text" class="form-control" id="empMarry" onclick="onClickMarry()" name="empMarital" placeholder="0为未婚，1为已婚"
                                   value="${(employees.empMarital)!''}"/>-->

                        </div>
                        <#--<div class="form-group">
                            <label>婚姻状况</label>
                            <input name="infMarital" type="text" class="form-control" value="${(information.infMarital)!''}"/>
                        </div>-->

                        <div class="form-group">
                            <label>备注</label>
                            <input name="infRemarks" type="text" id="infoRemarks" onclick="onClickRemarks()" class="form-control" value="${(information.infRemarks)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                        <input type="hidden" name="empId" value="${(information.empId)!''}">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <#-- 主要内容content end -->
</div>
</body>
</html>
