function inputNull(form) {
    for (i = 0; i < form.length; i++) {
        //form属性的elements的首字母e要小写
        if (form.elements[i].value == "") {
            alert(form.elements[i].placeholder + "不能为空");
            form.elements[i].focus();
            return false;
        }
    }
}