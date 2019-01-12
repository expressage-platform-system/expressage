//获取修改成员页面的X
const cancelBtn1 = document.getElementById("cancelAdd1");
//给修改成员页面的X注册点击事件：
cancelBtn1.onclick = function () {
    //将修改页面设置为隐藏
    document.getElementById("modifyPerson").style.display = "none";
};

//获取修改页面的提交按钮
const submitBtn1 = document.getElementById("modifyBtn");
//给提交按钮注册点击事件
submitBtn1.onclick = function () {
    // alert("进来了");
    // 获取修改成员页面中添加的修改的信息
    //获取新员工电话中的内容
    // let newPersonNumber = document.getElementById("phone").value;
    // 获取新员工的密码
    let newPersonPassword = document.getElementById("userPasswd").value;
    alert(
        "员工的电话" +
        document.getElementById("phone").value +
        "员工的密码" +
        newPersonPassword
    );
};