$(function () {
    $("#findAdminDot").append("<option value='0'>请选择</option>");
    $.ajax({
        type: "get",
        url: "/findAllAcBankName",
        dataType: "json",
        success: function (allAcBankName) {
            $("#province").append("<option value='0'>请选择</option>");
            for (var i = 0; i < allAcBankName.length; i++) {
                $("#findAdminDot").append("<option value='" + allAcBankName[i].bankId + "'>" + allAcBankName[i].bankName + "</option>");
            }
        }
    });
});

function adminlogin() {
    // if ($("select[name='adminDot']").val() != "" && $("input[name='adminDot']").val() != null) {
        if ($("input[name='adminAccount']").val() != "" && $("input[name='adminAccount']").val() != null) {
            if ($("input[name='adminPassword']").val() != "" && $("input[name='adminPassword']").val() != null) {
                $("form").submit();
            } else {
                alert("请输入密码");
            }
        } else {
            alert("请输入账号")
        }
    // }else{
    //     alert("请选择网点");
    // }
}
