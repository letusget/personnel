<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<script type="text/javascript">

    function onClickFlag() {}

    function onClickName()
    {
        //验证数字
        var patt=/^\d{n}$/;
        var userFlag=document.getElementById("userFlag").value;
        if (!userFlag)
        {
            alert("用户类型不能为空！");
        }

        /*if (!patt.test(userFlag))
        {
            alert(userFlag+" -> 用户类型不合规范，请重新选择！");
        }*/
    }

    function onClickMarks() {}

    function onsubmitFun()
    {

        var userFlag=document.getElementById("userFlag").value;
        var userName=document.getElementById("userName").value;

        if (!userFlag || !userName)
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
        <#include  "../common/nav.ftl">

        <!-- (4) 主要内容content start -->
        <div class="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <!--  复制 从 http://www.ibootstrap.cn 里面下载的内容 start -->
                    <div class="col-md-12 column">
                        <#--显示系统时间-->
                        <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                        <form role="form" method="post" action="/personnel/user/save" onsubmit="return onsubmitFun();">

                            <div class="form-group">
                                <label>用户类型</label>

                                <select class="form-control" id="userFlag" onclick="onClickFlag()" name="userFlag" placeholder="1 为经理，2 为员工"
                                        value="${(users.userFlag)!''}">
                                    <option style="display: none">请在下面选择要创建的用户类型</option>
                                    <option value="1">经理</option>
                                    <option value="2">员工</option>
                                </select>

                            </div>

                            <div class="form-group">
                                <label>用户名</label>
                                <input type="text" class="form-control" id="userName" onclick="onClickName()" name="userName" value="${(user.userName)!''}"/>
                            </div>

                            <#--<div class="form-group">
                                <label>密码</label><input type="password" class="form-control" id="userPassword" onclick="onClickPassword()" placeholder="默认密码为123456" name="userPassword" value="${(user.userPassword)!''}"/>
                            </div>-->

                            <div class="form-group">
                                <label>备注</label><input type="text" class="form-control" id="userRemarks" onclick="onClickMarks()" name="userRemarks" value="${(user.userRemarks)!''}"/>
                            </div>

                            <button type="submit" class="btn btn-default">创建</button>
                            <input  type="hidden" name="Id" value="${(user.userId)!''}">
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
