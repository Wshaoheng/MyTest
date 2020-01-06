$(function () {
    $("input[name='clientValidity1']").change(function () {
        if($("input[name='clientValidity1']").prop("checked")){
            $("input[name='clientValidity']").val("");
            $("input[name='clientValidity']").attr("disabled", "disabled");
        }else{
            $("input[name='clientValidity']").removeAttr("disabled");
        }
    });
    $("input[name='isAgent']").click(function () {
        var aaa = $('input:radio[name="isAgent"]:checked').val();
        if (aaa == 1) {
            $("#tdybo").remove();
        } else {
            $("#tblea").append(" <tbody id='tdybo'><tr>\n" +
                "            <td><span style=\"font-size: 20px;color: red\">代办人信息</span></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td colspan=\"2\">\n" +
                "                <hr width=\"\" color=\"red\"/>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">代办人姓名</td>\n" +
                "            <td><input type=\"text\" name=\"agentName\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\"> 代办人手机号:</td>\n" +
                "            <td><input type=\"text\" name=\"agentPhone\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">证件类型</td>\n" +
                "            <td><select name=\"agentType\">\n" +
                "                <option value=\"0\">身份证</option>\n" +
                "                <option value=\"1\">居民身份证</option>\n" +
                "                <option value=\"2\">出生证</option>\n" +
                "                <option value=\"3\">护照</option>\n" +
                "                <option value=\"4\">警官证</option>\n" +
                "                <option value=\"5\">执行公务证</option>\n" +
                "                <option value=\"6\">学生证</option>\n" +
                "            </select></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">证件号码:</td>\n" +
                "            <td><input type=\"text\" name=\"agentNum\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">重复证件号码:</td>\n" +
                "            <td><input name=\"agentNum1\" type=\"text\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">证件有效期:</td>\n" +
                "            <td><input id=\"demo\" type=\"date\" name=\"agentValidity\"/></td>\n" +
                "            <td><input type=\"checkbox\" onclick='getVa()' name=\"agentValidity1\" value=\"长期有效\" />长期有效</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">授权委托书有效期:</td>\n" +
                "            <td><input type=\"date\" name=\"agentPower\"/></td>\n" +
                "            <td><input type=\"checkbox\" onclick='getVa()' name=\"agentPower1\" value=\"长期有效\" />长期有效</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">代办人权限:</td>\n" +
                "            <td><select name=\"agentAgency\">\n" +
                "           <option value=\"\">请选择</option>\n" +
                "                <option value=\"0\">一般代办人</option>\n" +
                "                <option value=\"1\">高级代办人</option>\n" +
                "            </select></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">与申请人关系:</td>\n" +
                "            <td><select name=\"agentRelation\">\n" +
                "                <option value=\"\">请选择</option>\n" +
                "                <option value=\"亲属\">亲属</option>\n" +
                "                <option value=\"助理\">助理</option>\n" +
                "                <option value=\"其他\">其他</option>\n" +
                "            </select></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">代办理由:</td>\n" +
                "            <td><input type=\"text\" name=\"agentReson\" /></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">代办人地址:</td>\n" +
                "            <td><input type=\"text\" name=\"agentAddress\" /></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"fff\">代办人邮编:</td>\n" +
                "            <td><input type=\"text\" name=\"agentZipcode\" /></td>\n" +
                "        </tr></tbody>");
        }
    });
    $("select[name='laundMarriage']").change(function () {
        $("#theMarriage").empty();
        if ($("select[name='laundMarriage']").val() == "已婚" || $("select[name='laundMarriage']").val() == "丧偶") {
            $("#theMarriage").append("            <td class=\"fff\">证件登记地址:</td>\n" +
                "            <td><input name=\"laundAddress\" type=\"text\"/></td>");
        }
    })

})
function getVa() {
    if($("input[name='agentValidity1']").prop("checked")){
        $("input[name='agentValidity']").val("");
        $("input[name='agentValidity']").attr("disabled", "disabled");
    }else{
        $("input[name='agentValidity']").removeAttr("disabled");
    }

    if($("input[name='agentPower1']").prop("checked")){
        $("input[name='agentPower']").val("");
        $("input[name='agentPower']").attr("disabled", "disabled");
    }else{
        $("input[name='agentPower']").removeAttr("disabled");
    }
}



function addAcClient() {
    if ($("input[name='clientName']").val() == "" || $("input[name='clientName']").val() == null) {
        alert("请输入客户姓名");
        return;
    }
    if ($("select[name='clientSex']").val() == "" || $("select[name='clientSex']").val() == null) {
        alert("请选择客户性别");
        return;
    }
    if ($("select[name='clientType']").val() == "" || $("select[name='clientType']").val() == null) {
        alert("请选择客户证件类型");
        return;
    }
    if ($("input[name='clientNum']").val() == "" || $("input[name='clientNum']").val() == null) {
        alert("请输入客户证件号码")
        return;
    }
    if(!($("input[name='clientValidity1']").prop("checked"))){
        if ($("input[name='clientValidity']").val() == "" || $("input[name='clientValidity']").val() == null) {
            alert("请录入客户证件有效期日期")
            return;
        }
    }
    if ($("input[name='clientBirthday']").val() == "" || $("input[name='clientBirthday']").val() == null) {
        alert("请录入客户生日")
        return;
    }
    if ($("select[name='clientProvince']").val() == 0 || $("select[name='clientProvince']").val() == null) {
        alert("请选择当前省");
        return;
    }
    if ($("select[name='clientCity']").val() == 0 || $("select[name='clientCity']").val() == null) {
        alert("请选择当前市");
        return;
    }
    if ($("input[name='clientAddress']").val() == "" || $("input[name='clientAddress']").val() == null) {
        alert("请输入客户详细地址");
        return;
    }
    if ($("input[name='clientPostcode']").val() == "" || $("input[name='clientPostcode']").val() == null) {
        alert("请输入邮政编码");
        return;
    }
    if ($("input[name='clientTel']").val() == "" || $("input[name='clientTel']").val() == null) {
        alert("请输入联系电话");
        return;
    }
    if ($("input[name='clientPhone']").val() == "" || $("input[name='clientPhone']").val() == null) {
        alert("请输入手机号");
        return;
    }
    if ($("select[name='clientOccupation']").val() == "" || $("select[name='clientOccupation']").val() == null) {
        alert("请选择客户职业");
        return;
    }
    if ($("input[name='clientBeneficiary']").val() == "" || $("input[name='clientBeneficiary']").val() == null) {
        alert("请输入实际受益人");
        return;
    }
    if ($("input[name='clientController']").val() == "" || $("input[name='clientController']").val() == null) {
        alert("请输入实际控制人");
        return;
    }
    if ($("select[name='clientExperience']").val() == "" || $("select[name='clientExperience']").val() == null) {
        alert("请选择客户是否有过投资经历");
        return;
    }
    if ($("input[name='clientPassword']").val() == "" || $("input[name='clientPassword']").val() == null) {
        alert("请让客户输入密码");
        return;
    }
    if ($("select[name='laundNationality']").val() == "" || $("select[name='laundNationality']").val() == null) {
        alert("请选择客户国籍");
        return;
    }
    if ($("input[name='clientPassword']").val() == "" || $("input[name='clientPassword']").val() == null) {
        alert("请让客户输入密码");
        return;
    }
    if ($("select[name='laundAnnualincome']").val() == "" || $("select[name='laundAnnualincome']").val() == null) {
        alert("请选择客户年收入");
        return;
    }
    if ($("select[name='laundEducation']").val() == "" || $("select[name='laundEducation']").val() == null) {
        alert("请选择客户学历");
        return;
    }
    if ($("input[name='laundSocial']:checked").val() != 1 && $("input[name='laundSocial']:checked").val() != 0) {
        alert("请选择客户是否政要或其亲属");
        return;
    }
    if ($("input[name='laundRisk']:checked").val() != 1 && $("input[name='laundRisk']:checked").val() != 0) {
        alert("请选择客户是否从事高风险行业");
        return;
    }
    if ($("select[name='laundMarriage']").val() == "" || $("select[name='laundMarriage']").val() == null) {
        alert("请选择客户婚姻状态");
        return;
    }
    if ($("select[name='laundMarriage']").val() == "已婚" || $("select[name='laundMarriage']").val() == "丧偶") {
        if ($("input[name='laundAddress']").val() == "" || $("input[name='laundAddress']").val() == null) {
            alert("请选择客户证件登记地址");
            return;
        }
    }
    if ($("select[name='laundGrade']").val() == "" || $("select[name='laundGrade']").val() == null) {
        alert("请选择客户反洗钱风险登记");
        return;
    }
    if ($('input:radio[name="isAgent"]:checked').val() == null) {
        alert("请选择是否是本人办理")
    }
    if ($('input:radio[name="isAgent"]:checked').val() == 2) {
        if ($("input[name='agentName']").val() == "" || $("input[name='agentName']").val() == null) {
            alert("代办人姓名不能为空");
            return;
        }
        if ($("input[name='agentPhone']").val() == "" || $("input[name='agentPhone']").val() == null) {
            alert("代办人手机号不能为空");
            return;
        }
        if ($("select[name='agentType']").val() == "" || $("select[name='agentType']").val() == null) {
            alert("请选择代办人证件类型");
            return;
        }
        if ($("input[name='agentNum']").val() == "" || $("input[name='agentNum']").val() == null) {
            alert("请输入代办人证件号码");
            return;
        }
        if(!($("input[name='agentValidity1']").prop("checked"))){
            if ($("input[name='agentValidity']").val() == "" || $("input[name='agentValidity']").val() == null) {
                alert("请选择证件有效期");
                return;
            }
        }
        if(!($("input[name='agentPower1']").prop("checked"))){
            if ($("input[name='agentPower']").val() == "" || $("input[name='agentPower']").val() == null) {
                alert("请选择授权委托书有效期");
                return;
            }
        }
        if ($("select[name='agentAgency']").val() == "" || $("select[name='agentAgency']").val() == null) {
            alert("请选择代办人权限");
            return;
        }
        if ($("select[name='agentRelation']").val() == "" || $("select[name='agentRelation']").val() == null) {
            alert("请选择与申请人关系");
            return;
        }
        if ($("input[name='agentReson']").val() == "" || $("input[name='agentReson']").val() == null) {
            alert("请输入代办理由");
            return;
        }
        if ($("input[name='agentAddress']").val() == "" || $("input[name='agentAddress']").val() == null) {
            alert("请输入代办人地址");
            return;
        }
        if ($("input[name='agentZipcode']").val() == "" || $("input[name='agentZipcode']").val() == null) {
            alert("请输入代办人邮编");
            return;
        }
    }
    if ($("input[name='clientNum']").val() != $("input[name='clientNum1']").val()) {
        alert("输入的两次客户证号信息不一样");
        return;
    }
    if ($("input[name='clientPassword']").val() != $("input[name='clientPassword1']").val()) {
        alert("客户输入的两次交易密码不一样");
        return;
    }
    if ($("input[name='agentNum']").val() != $("input[name='agentNum1']").val()) {
        alert("代办人的证件号信息不一样");
        return;
    }
    document.getElementById("rmor").submit();

}
