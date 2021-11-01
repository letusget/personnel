<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">
<script type="text/javascript">
    function onClickDescription()
    {
        var depName=document.getElementById("depName");
        var depNameText=depName.value;
        if (!depNameText)
        {
            alert("部门名称不能为空");
        }

        var ptty=/^[\u0391-\uFFE5]+$/;
        if (!ptty.test(depNameText))
        {
            alert(depNameText+" -> 请输入中文部门名称");
        }
    }

    function onClickRemarks()
    {
        var depDescription=document.getElementById("depDescribes");
        var depDescriptionText=depDescription.value;
        if(!depDescriptionText)
        {
            alert("部门描述不能为空");
        }

        var ptty=/^[\u0391-\uFFE5]{1,100}$/;
        if (!ptty.test(depDescriptionText))
        {
            alert(depDescriptionText+" -> 请输入中文描述，且不超过100字");
        }

    }



    function onsubmitFun()
    {
        var depName=document.getElementById("depName").value;
        var depDescription=document.getElementById("depDescribes").value;
        if(!depName||!depDescription)
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
                    <form role="form" method="post" action="/personnel/departments/save" onsubmit="return onsubmitFun();">
                        <!--
                        <div class="form-group">
                            <label>部门ID</label><input type="text" class="form-control" id="depId" name="depId" !''}"/>
                        </div>
                        -->
                        <div class="form-group">
                            <label>部门名称</label>
                            <input type="text" class="form-control" placeholder="中文名称"
                                                      id="depName" name="depName" value="${(departments.depName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>部门描述</label><input type="text" onclick="onClickDescription()"
                                                      class="form-control" id="depDescribes" placeholder="简明扼要的中文描述，字数不超过100字"
                                                      name="depDescribes" value="${(departments.depDescribes)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>备注</label><input type="text" onclick="onClickRemarks()" class="form-control" id="depRemarks" name="depRemarks" value="${(departments.depRemarks)!''}"/>
                        </div>

                        <button type="submit" class="btn btn-default">提交结果</button>
                        <input  type="hidden" name="depId" value="${(departments.depId)!''}">
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