function addAccCount() {

    if(    $("input[name='customerName']").val()==""||$("input[name='customerName']").val()==null){
        alert("请输入客户全称！");
        return;
    }
    if($("select[name='certificateType']").val()==""||$("select[name='certificateType']").val()==null){
        alert("请选择证件类型！");
        return;
    }
    if($("input[name='certificateNum']").val()==""||$("input[name='certificateNum']").val()==null){
        alert("请输入证件号码！");
        return;
    }

    if($("input[name='certificateNum']").val()!=$("input[name='certificateNum1']").val()){
        alert("证件号码不一致，请重新输入！");
        return;
    }
        var checkedValue = $("input:checkbox[name='certificateValidity1']:checked").val();
    if(($("input[name='certificateValidity']").val()==""||$("input[name='certificateValidity']").val()==null)
    &&checkedValue==null){
        alert("请选择证件有效期")
        return;
    }

    if($("select[name='province']").val()==""||$("select[name='province']").val()==null){
        alert("请选择省！");
        return;
    }
    if($("select[name='city']").val()==""||$("select[name='city']").val()==null){
        alert("请选择市！");
        return;
    }
    if($("input[name='correspondenceAddress']").val()==""||$("input[name='correspondenceAddress']").val()==null){
        alert("请输入通讯地址！");
        return;
    }
    if($("input[name='postCode']").val()==""||$("input[name='postCode']").val()==null){
        alert("请输入邮政编码！");
        return;
    }
    if($("input[name='telphone1']").val()==""||$("input[name='telphone1']").val()==null){
        alert("请输入联系电话！");
        return;
    }
    if($("select[name='customService']").val()==""||$("select[name='customService']").val()==null){
        alert("请选择服务类型！");
        return;
    }
    if($("input[name='tradePassword']").val()==""||$("input[name='tradePassword']").val()==null){
        alert("请输入交易密码！");
    }
    if($("input[name='tradePassword']").val()!=$("input[name='tradePassword1']").val()){
        alert("两次输入的密码不一致，请重新输入！");
        return;
    }

  /*


    var chanV = $("input:checkbox[name='channelId']:checked").val();
    if(chanV!=1){
        $("input:checkbox[name='channelId']").val("0");
    }

    var commV = $("input:checkbox[name='commissionedByFacsimile']:checked").val();
    if(commV!=1){
        $("input:checkbox[name='commissionedByFacsimile']").val("0");
    }
*/

    if($("input[name='legalPersonName']").val()==""||$("input[name='legalPersonName']").val()==null){
        alert("请输入法人姓名！");
        return;
    }
    if($("select[name='corporateDocumentType']").val()==""||$("select[name='corporateDocumentType']").val()==null){
        alert("请请选择法人证件类型！");
        return;
    }
    if($("input[name='corporateNumber']").val()==""||$("input[name='corporateNumber']").val()==null){
        alert("请输入法人证件号码！");
        return;
    }

    var legValue = $("input:checkbox[name='legalPeriodOfLegalPerson1']:checked").val();
    if(($("input[name='legalPeriodOfLegalPerson']").val()==""||$("input[name='legalPeriodOfLegalPerson']").val()==null)
    &&legValue==null){
        alert("请输入法人证件有效期！");
        return;
    }
    if($("input[name='organizationCode']").val()==""||$("input[name='organizationCode']").val()==null){
        alert("请输入组织机构代码！");
        return;
    }
    if($("input[name='organizationCodeExpirationDate']").val()==""||$("input[name='organizationCodeExpirationDate']").val()==null){
        alert("请输入组织机构代码有效期！");
        return;
    }
    if($("input[name='taxRegistrationNumber']").val()==""||$("input[name='taxRegistrationNumber']").val()==null){
        alert("请输入税务登记证号码！");
        return;
    }
    if($("input[name='nameOfPersonInCharge']").val()==""||$("input[name='nameOfPersonInCharge']").val()==null){
        alert("请输入负责人姓名！");
        return;
    }
    if($("select[name='responsiblePersonType']").val()==""||$("select[name='responsiblePersonType']").val()==null){
        alert("请输入负责人证件类型！");
        return;
    }
    if($("input[name='responsiblePersonNumber']").val()==""||$("input[name='responsiblePersonNumber']").val()==null){
        alert("请输入负责人证件号码！");
        return;
    }
            var cerValue = $("input:checkbox[name='principalValidityPeriod1']:checked").val();
    if(($("input[name='principalValidityPeriod']").val()==""||$("input[name='principalValidityPeriod']").val()==null)
    &&cerValue==null){
        alert("请输入负责人证件有效期！");
        return;
    }
    if($("input[name='controllingShareholderName']").val()==""||$("input[name='controllingShareholderName']").val()==null){
        alert("请输入控股股东名称！");
        return;
    }
    if($("select[name='controllingShareholderType']").val()==""||$("select[name='controllingShareholderType']").val()==null){
        alert("请选择控股股东类别！");
        return;
    }
    if($("select[name='controllingShareholderTypeOfCertificate']").val()==""||$("select[name='controllingShareholderTypeOfCertificate']").val()==null){
        alert("请选择控股股东证件类型！");
        return;
    }
    if($("input[name='controllingShareholderLicenseNumber']").val()==""||$("input[name='controllingShareholderLicenseNumber']").val()==null){
        alert("请输入控股股东证件号！");
        return;
    }
    if($("input[name='controllingShareholderLicenseNumberTime']").val()==""||$("input[name='controllingShareholderLicenseNumberTime']").val()==null){
        alert("请输入控股股东证件有效期！");
        return;
    }
    if($("input[name='businessScope']").val()==""||$("input[name='businessScope']").val()==null){
        alert("请选择经营范围！");
        return;
    }
    if($("input[name='actualAccountController']").val()==""||$("input[name='actualAccountController']").val()==null){
        alert("请输入账户实际控制人！");
        return;
    }
    if($("input[name='actualBeneficiaryOfTheAccount']").val()==""||$("input[name='actualBeneficiaryOfTheAccount']").val()==null){
        alert("请输入账户实际受益人！");
        return;

    }
    if($("input[name='registeredCapital']").val()==""||$("input[name='registeredCapital']").val()==null){
        alert("请输入注册资本！");
        return;
    }

    $("#form_accClient").submit();

}

$(function () {


    if($("input:checkbox[name='sendConfirmation']").prop("checked",false)){
        $("input:checkbox[name='sendConfirmation']").val("0");
    }

        //判断客户的证件有效期是否选择
    $("input[name='certificateValidity1']").change(function () {
        if ($("input[name='certificateValidity1']").prop("checked")) {
            $("input[name='certificateValidity']").val("");
            $("input[name='certificateValidity']").attr("disabled", "disabled");
        } else {
            $("input[name='certificateValidity']").removeAttr("disabled");
        }
    })

        //判断法人证件有效期是否选择
    $("input[name='legalPeriodOfLegalPerson1']").change(function () {
        if ($("input[name='legalPeriodOfLegalPerson1']").prop("checked")) {
            $("input[name='legalPeriodOfLegalPerson']").val("");
            $("input[name='legalPeriodOfLegalPerson']").attr("disabled", "disabled");
        } else {
            $("input[name='legalPeriodOfLegalPerson']").removeAttr("disabled");
        }
    })

        //判断负责人证件有效期是否选择
    $("input[name='principalValidityPeriod1']").change(function () {
        if ($("input[name='principalValidityPeriod1']").prop("checked")) {
            $("input[name='principalValidityPeriod']").val("");
            $("input[name='principalValidityPeriod']").attr("disabled", "disabled");
        } else {
            $("input[name='principalValidityPeriod']").removeAttr("disabled");
        }
    })


});

