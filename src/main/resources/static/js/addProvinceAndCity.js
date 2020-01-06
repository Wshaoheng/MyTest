$(function () {
    $(".form-shi").append("<option value='0'>请选择</option>");
    $.ajax({
        type: "get",
        url: "getAllProvince",
        dataType: "json",
        success: function (acProvinceList) {
            $(".form-province").append("<option value='0'>请选择</option>");
            for (var i = 0; i < acProvinceList.length; i++) {
                $(".form-province").append("<option value='" + acProvinceList[i].provinceCode + "'>" + acProvinceList[i].provinceName + "</option>");
            }
        }
    });
});
function getCity() {
    var provinceCode = $(".form-province").val();
    $(".form-shi").empty();
    $(".form-shi").append("<option value='0'>请选择</option>");
    if (provinceCode != "" && provinceCode != null) {
        $.ajax({
            type: "get",
            url: "getCityByCode",
            data: {
                "code": provinceCode
            },
            dataType: "json",
            success: function (acCities) {
                for (var i = 0; i < acCities.length; i++) {
                    $(".form-shi").append("<option value='" + acCities[i].cityId + "'>" + acCities[i].cityName + "</option>");
                }
            }
        });
    }
}


