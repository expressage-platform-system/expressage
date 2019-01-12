var pencilBtnObj = document.getElementsByClassName('pencil');
var personNum;
for (
    let i = 0; i < pencilBtnObj.length; i++
) {
    let index = i;
    let indexPencil = parseInt(index) + 1;
    document.getElementsByClassName("pencil")[i].onclick = function () {
        document.getElementById("modifyPerson").style.display = "block";
        var trObj = document.getElementsByTagName("tr");
        for (let j = 1; j < trObj.length; j++) {
            var indexTr = j;
            if (parseInt(index) + 1 == parseInt(indexTr)) {
                break;
            }
        }
        personNum = document.getElementsByTagName('tr')[indexTr].getElementsByTagName('td')[2].innerText;
    }
};

var modifyBtn0 = document.getElementById("modifyBtn0");
modifyBtn0.onclick = function () {
    if (document.getElementById("userPasswd").value){
        $.ajax({
            url: "/changePasswd",
            type: 'POST',
            data:{
                adminNum:personNum,
                adminPasswd:document.getElementById("userPasswd").value
            },
            success: function (res) {
                window.location.href = "/index"
            }
        });
        document.getElementById("modifyPerson").style.display = "none"
    } else{
        alert("请输入新密码！")
    }

}