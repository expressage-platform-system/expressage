//设置如果页面缩小，那么将注册页面右边的区域隐藏

//浏览器的宽度

let objWidth = document.body.clientWidth;
console.log(objWidth);

//拿到浏览器高度
let objHeight = document.body.clientHeight;
console.log(objHeight);

let imgObj = document.getElementById("imArea");
if(objWidth < 1000){
    imgObj.style.display = "none";
    // console.log("小于1200");
}else{
    imgObj.style.display = "block";
    // console.log("大于1200");
}
