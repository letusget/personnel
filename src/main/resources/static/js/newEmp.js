//失去焦点事件
window.onload=function ()
{
    //获取标签对象
    var empPhoto=document.getElementsByName("empPhoto");
    empPhoto.onblur=function ()
    {
        alert("照片不能为空！");
    }
}