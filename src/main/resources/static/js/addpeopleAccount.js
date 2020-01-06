$(function () {
    $("#shi").append("<option value='0'>请选择</option>");
    $.ajax({
        type: "get",
        url: "getAllProvince",
        dataType: "json",
        success: function (acProvinceList) {
            $("#province").append("<option value='0'>请选择</option>");
            for (var i = 0; i < acProvinceList.length; i++) {
                $("#province").append("<option value='" + acProvinceList[i].provinceCode + "'>" + acProvinceList[i].provinceName + "</option>");
            }
        }
    });
});
function getCityes() {
    var provinceCode = $("#province").val();
    $("#shi").empty();
    $("#shi").append("<option value='0'>请选择</option>");
    if (provinceCode != "" && provinceCode != null) {
        $.ajax({
            type: "get",
            url: "getCityByCode",
            data: {
                "code": provinceCode
            },
            dataType: "json",
            success: function (shi) {
                for (var i = 0; i < shi.length; i++) {
                    $("#shi").append("<option value='" + shi[i].cityId + "'>" + shi[i].cityName + "</option>");
                }
            }
        });
    }
}


