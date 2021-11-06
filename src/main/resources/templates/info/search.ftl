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
                    <form role="form" method="get" action="/personnel/info/result?empName=empName">
                        <div class="form-group">
                            <label>输入员工姓名</label>
                            <input type="text" class="form-control" id="productPrice" name="empName"/>
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>

                    <form role="form" method="get" action="/personnel/info/result2?infEducation=infEducation">
                        <div class="form-group">
                            <label>输入员工学历</label>
                            <input type="text" class="form-control" id="productPrice" name="infEducation"/>
                        </div>

                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>

                    <form role="form" method="get" action="/personnel/info/result3?infPolitical=infPolitical">
                        <div class="form-group">
                            <label>输入员工政治面貌</label>
                            <#-- <input type="text" class="form-control" id="productPrice" name="depName"/>-->
                            <select class="form-control" id="infPolitical" onclick="onClickSex()" name="infPolitical" placeholder="0 为共产党员，1 为共青团员,2为群众，3为无党派人士"
                                    value="${(information.infPolitical)!''}">
                                <option style="display: none">请在下面选择政治面貌</option>
                                <option value="0">共产党员</option>
                                <option value="1">共青团员</option>
                                <option value="2">群众</option>
                                <option value="3">无党派人士</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-default" >搜索</button>
                    </form>

                    <form role="form" method="get" action="/personnel/info/result4?infMarital=infMarital">
                        <div class="form-group">
                            <label>输入员工婚姻状况</label>
                            <#-- <input type="text" class="form-control" id="productPrice" name="depName"/>-->
                            <select class="form-control" id="infMarital" onclick="onClickSex()" name="infMarital" placeholder="0 为共产党员，1 为共青团员,2为群众，3为无党派人士"
                                    value="${(information.infPolitical)!''}">
                                <option style="display: none">请在下面选择婚姻状况</option>
                                <option value="0">未婚</option>
                                <option value="1">已婚</option>
                                <option value="2">离异</option>
                                <option value="3">丧偶</option>
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
