$(function () {

})
if(document.getElementById("birthday")) {
    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        method: "POST",
        error: function (data) {
            console.log(data);
        },
        success: function (data) {
            console.log(data);
            $("#birthday").val(data["birthday"]);
            $("#headImage").attr("src", data["headimage"]);
        }
    });
}
setInterval(getUserInfo,1000);
function getUserInfo() {
    if(document.getElementById("birthday")) {
        $.ajax({
            url: "/getUserInfo",
            dataType: "json",
            method: "POST",
            error: function (data) {
                console.log(data);
            },
            success: function (data) {
                console.log(data);
                $("#birthday").val(data["birthday"]);
                $("#headImage").attr("src", data["headimage"]);
            }
        });
    }
}

function verify_pwd(){
    var password= $("#password").val();
    var confirmPassword = $("#confirmpassword").val();
    if(!password||!confirmPassword||password!=confirmPassword){
        alert("两次密码输入不一致!");
        return false;
    }
    return true;
}
function healthForm(){
    var age= $("#healthAge").val();
    var height=$("#healthHeight").val();
    var weight=$("#healthWeight").val();
    var waist = $("#healthWaist").val();
    var vision = $("#healthVision").val();
    var heartRate = $("#healthHeartRate").val();
    if(age<0 || age >120) {
        alert("请输入合理的年龄.");
        return false;
    }
    if(vision<4.5 ||  vision >5.3){
        alert("视力范围请输入合理的值.");
        return false;
    }
    if(weight<40 || weight >250){
        alert("体重请输入合理的值");
        return false;
    }
    if(waist<40 || waist>120){
        alert("腰围请输入合理的值");
        return false;
    }
    if(heartRate<60 || heartRate >100){
        alert("平均心率请输入合理的值.");
        return false;
    }
    return true;
}

function messageForm(){
    var userid= $("#userid").val();
    if(userid==0){
        alert("请先登录");
        return false;
    }
    return true;
}
