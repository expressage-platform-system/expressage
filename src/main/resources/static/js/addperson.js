var cancelBtn = document.getElementById("cancelAdd");

cancelBtn.onclick = function () {

    document.getElementById("addPerson").style.display = "none";
};

//获取员工账号框的对象
var  personNumberObj = document.getElementById('personNumber');
personNumberObj.onblur = function () {
// alert('这是员工账号');
    $.ajax({
        url: '/checkOne',
        type: 'POST',
        data:{
            adminNum:personNumberObj.value
        },
        success: function (res) {
            if (!res){
                personNumberObj.style.borderColor = 'red';
                document.getElementById('newPerson').disabled=true;
            }
            else{
                personNumberObj.style.borderColor = '';
                document.getElementById('newPerson').disabled=false;
            }
        }
    })
}





//添加成员
var newPersonObj = document.getElementById('addBtn');

newPersonObj.onclick = function () {
    document.getElementById("addPerson").style.display = "block";
}