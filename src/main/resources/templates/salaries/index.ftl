<#--
<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">
    &lt;#&ndash; 边栏sidebar &ndash;&gt;
    <#include "../common/nav.ftl">

    &lt;#&ndash; 主要内容content start &ndash;&gt;
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/personnel/salaries/save">
                        <div class="form-group">
                            <label>员工姓名</label>
                            <input name="empName" type="text" class="form-control"
                                   value="${(salaries.empName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>基本金额</label>
                            <input name="salBase" type="number" class="form-control" value="${(salaries.salBase)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>奖金金额</label>
                            <input name="salBonus" type="number" class="form-control" value="${(salaries.salBonus)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>奖金描述</label>
                            <input name="salBonusDescribes" type="text" class="form-control" value="${(salaries.salBonusDescribes)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>扣除金额</label>
                            <input name="salFine" type="number" class="form-control" value="${(salaries.salFine)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>扣除描述</label>
                            <input name="salFineDescribes" type="text" class="form-control" value="${(salaries.salFineDescribes)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>保险福利</label>
                            <input name="salBenefits" type="number" class="form-control" value="${(salaries.salBenefits)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>备注</label>
                            <input name="salRemarks" type="text" class="form-control" value="${(salaries.salRemarks)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                        <input type="hidden" name="empId" value="${(salaries.empId)!''}">
                    </form>
                </div>
            </div>
        </div>
    </div>
    &lt;#&ndash; 主要内容content end &ndash;&gt;
</div>
</body>
</html>
-->
