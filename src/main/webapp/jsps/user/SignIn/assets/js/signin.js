function showError(ele) {
    var text=ele.text();
    if(!text){
        ele.css("display","none");
    }
    else{
        ele.css("display","block");
    }
}
$(function () {
    /*输入框得到焦点进行错误信息隐藏*/
    $(".form-control").focus(function () {
        var errorId=$(this).attr("id")+"Error";
        $("#"+errorId).text("");
    });

    /*输入框失去焦点进行校验*/
    $(".form-control").blur(function () {
        var id=$(this).attr("id");
        var method_name="valid"+id;
        eval(method_name+"()");
    });
});

/*注册名校验*/
function validusername() {
    var id="username"
    var value=$("#"+id).val();
    $.ajax({
        url: "/things_web/UserController/findUserByUsername.action",
        data: {username: value},
        async: false,
        caches: false,
        type: "POST",
        dataType: "json",
        success: function (result) {
            if (result==true) {
                flag = true;
            }
            else {
                $("#" + id + "Error").text("用户名不存在");
                showError($("#" + id + "Error"));
                flag = false;
            }
        }
    });
    return flag;
}

$("#registForm").submit(function () {
    var flag=true;
    if(!validusername()){
        flag=false;
    }
    if(!validpassword()){
        flag=false;
    }
    return flag;
})