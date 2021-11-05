<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<script type="text/javascript">

    /*function onblurPhoto()
    {
        var empPhoto=document.getElementById("empPhoto");
        //alert("success");
        var photoText=empPhoto.value;
        //alert(photoText);
        //var patt=/^[a-z]$/
        if(!photoText)
        {
            //alert("照片不能为空");
            //empPhoto.innerHTML="照片不能为空！";
        }

    }
*/
    function onClickName()
    {
        var empPhoto=document.getElementById("empPhoto");
        var photoText=empPhoto.value;
        if(!photoText)
        {
            alert("照片不能为空");
        }

        var patt=/^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
        if (!patt.test(photoText))
        {
            alert("请检查证件照来源，输入正确链接");
        }
    }

    function onClickSex() {
        var empName=document.getElementById("empName");
        var empNameText=empName.value;

        if (!empName)
        {
            alert("姓名不能为空");
        }

        var patt=/^[\u4E00-\u9FA5]{2,10}(·[\u4E00-\u9FA5]{2,10}){0,2}$/;
        if (!patt.test(empNameText))
        {
            alert(empNameText+" -> 此姓名输入不合规范，请输入真实姓名！");
        }
    }

    function onClickEmail()
    {
        /*var empSex = document.getElementById("empName");
        var empNameText=empName.value;
        if(!empNameText)
        {

        }*/

        //验证数字
        var patt=/^\d{n}$/;
        var empSex=document.getElementById("empSex").value;
        if (!empSex)
        {
            alert("性别不能为空！");
        }

        if (!patt.test(empSex))
        {
            alert(empSex+" -> 性别选择不合规范，请重新选择！");
        }



    }

    function onClickPhone()
    {
        var empEmail=document.getElementById("empEmail");
        var empEmailText=empEmail.value;
        if (!empEmailText)
        {
            alert("邮箱不能为空！");
        }

        //验证邮箱格式，
        var patt=/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.]){1,2}[A-Za-z\d]{2,5}$/g;
        if(!patt.test(empEmailText))
        {
            alert(empEmailText+" -> 邮箱格式不正确，请检查后重新输入！");
        }

    }

    function onClickNumber()
    {
        var empPhone=document.getElementById("empPhone");
        var empPhoneText=empPhone.value;
        if (!empPhoneText)
        {
            alert("手机号码不能为空");
        }
        //11 位手机号码
        var patt=/^1[3-9]\d{9}$/;
        if(!patt.test(empPhoneText))
        {
            alert(empPhoneText+" -> 手机号码不合规范，请输入有效的11位手机号码！");
        }

    }

    function onClickMarks()
    {
        //对身份证号码进行输入检查
        var checkCode = function (val) {
            var p = /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
            var code = val.substring(17);
            if(p.test(val)) {
                var sum = 0;
                for(var i=0;i<17;i++) {
                    sum += val[i]*factor[i];
                }
                if(parity[sum % 11] == code.toUpperCase()) {
                    return true;
                }
            }
            return false;
        }

        var empNumber=document.getElementById("empNumber");
        var empNumberText=empNumber.value;
        if (!empNumberText)
        {
            alert("身份证号码不能为空");

        }

        if (!checkCode(empNumberText))
        {
            alert(empNumberText+" -> 身份证号码输入有误，请检查后重新输入！");
        }

    }

    function onsubmitFun()
    {

        var empSex=document.getElementById("empPhone").value;
        var empPhoto=document.getElementById("empPhoto").value;
        var empPhone=document.getElementById("empPhoto").value;
        var empNumber=document.getElementById("empNumber").value;
        var empEmail=document.getElementById("empEmail").value;
        var empName = document.getElementById("empName").value;


        if (!empSex || !empPhoto ||!empNumber||!empPhone||!empEmail||!empName)
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
    <#include  "../common/navEmployee.ftl">

    <!-- (4) 主要内容content start -->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <!--  复制 从 http://www.ibootstrap.cn 里面下载的内容 start -->
                <div class="col-md-12 column">
                    <#--显示系统时间-->
                    <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                    <form role="form" method="post" action="/personnel/employees/save2" onsubmit="return onsubmitFun();">

                        <div class="form-group">
                            <label>员工照片</label>
                            <img height="100px;" width="100px;" src="${(employees.empPhoto)!''}" alt="该图片不存在!"/> <br/>
                            <#--onblur="onblurPhoto();" -->
                            <input id="empPhoto" name="empPhoto" type="text" placeholder="建议使用在线图床图片" value="${(employees.empPhoto)!''}" width="50%"/>
                        </div>

                        <div class="form-group">
                            <label>员工姓名</label>
                            <input type="text" class="form-control" id="empName" onclick="onClickName()" name="empName" value="${(employees.empName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工性别</label>

                            <select class="form-control" id="empSex" onclick="onClickSex()" name="empSex" placeholder="0 为女性，1 为男性"
                                    value="${(employees.empSex)!''}">
                                <option style="display: none">请在下面选择性别</option>
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>

                            <#--<input type="text" class="form-control" id="empSex" onclick="onClickSex()" name="empSex" placeholder="0 为女性，1 为男性"
                                   value="${(employees.empSex)!''}"/>-->

                        </div>

                        <div class="form-group">
                            <label>员工邮箱</label><input type="text" class="form-control" id="empEmail" onclick="onClickEmail()" placeholder="建议使用主流邮箱域名" name="empEmail" value="${(employees.empEmail)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工手机号码</label><input type="text" class="form-control" id="empPhone" onclick="onClickPhone()" placeholder="请输入有效的11位手机号码" name="empPhone" value="${(employees.empPhone)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>员工身份证号码</label><input type="text" class="form-control" id="empNumber" onclick="onClickNumber()" name="empIdCard" placeholder="请输入中国大陆第二代身份证号码" value="${(employees.empIdCard)!''}"/>
                        </div>

                        <#--
                        <div class="form-group">
                            <label>员工入职时间</label><input type="text" class="form-control" id="productName" name="productName" value="${(employees.empEntry)!''}"/>
                        </div>
                        -->


                        <div class="form-group">
                            <label>员工备注</label><input type="text" class="form-control" id="productName" onclick="onClickMarks()" name="empRemarks" value="${(employees.empRemarks)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>部门规划</label>
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

                        <button type="submit" class="btn btn-default">提交结果</button>
                        <input  type="hidden" name="empId" value="${(employees.empId)!''}">
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
