// // 绑定点击事件
// // document.querySelector('#inputPassword3').onclick = function () {
//
//
//
//
//




//使用JS发送请求
// //公司给员工添加账号进行Ajax验证
// // 绑定点击事件
// document.querySelector('#newPersonNumber').onblur = function () {
//     // 发送ajax 请求 需要 五步
//
//     // （1）创建异步对象
//     let ajaxObj = new XMLHttpRequest();
//
//     // （2）设置请求的参数。包括：请求的方法、请求的url。
//     ajaxObj.open('get', '../js/1.php');
//
//     // （3）发送请求
//     ajaxObj.send('');
//
//     //（4）注册事件。 onreadystatechange事件，状态改变时就会调用。
//     //如果要在数据完整请求回来的时候才调用，需要手动写一些判断的逻辑。
//     ajaxObj.onreadystatechange = function () {
//         // 为了保证 数据 完整返回，一般会判断 两个值
//         if (ajaxObj.readyState == 4 && ajaxObj.status == 200) {
//             // 如果能够进到这个判断 说明 数据 完美的回来了,并且请求的页面是存在的
//             // 5.在注册的事件中 获取 返回的 内容 并修改页面的显示
//             alert('数据返回成功');
//
//             // 数据是保存在 异步对象的 属性中
//             alert(ajaxObj.responseText);
//
//             // 修改页面的显示
//             document.getElementById("#newPersonNumber").style.backgroundColor = "red";
//             alert("该用户名以存在");
//         }
//     }
// };




//使用jQ发送Ajax
document.getElementById("newPersonNumber").onblur = function(){
    console.log("进来了");
    $.ajax({
        url: ".js/1.php",
        data: {name: 'success!'},
        type: "POST",
        dataType: "json",
        success: function (data) {
            alert("data!");
        }
    });
};


