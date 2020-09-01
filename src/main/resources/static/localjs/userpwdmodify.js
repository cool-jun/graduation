$(function () {
    let ok = false;
    //验证新密码是否一致
    $("#password2").blur(function () {
        let pwd2 = $(this).val();
        let pwd1 = $("#password1").val();
        let reg = /^\w{6,}$/;
        if (reg.test(pwd2)) {
            if (pwd1 === pwd2) {
                $("#msg_pwd").html("<span style="color: green; ">两次密码一致</span>");
                ok = true;
            } else {
                $("#msg_pwd").html("<span style="color: red; ">两次密码不一致</span>");
                ok = false;
            }
        }
    });

    //提交表单
    $("#pwdmodify").click(function () {
        if (ok) {
            document.forms[0].submit();
        } else {
            alert("输入有误！")
        }
    })
});
