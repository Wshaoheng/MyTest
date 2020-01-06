$("#search").click(function () {
       var count =$("#accValue").val();
       var pwd = $("#pwd").val();
       var data = count;
       /*var tradePassword = pwd;*/
       $.ajax({
          url:"accClient/toEditInfo",
           data:{"accAccount":data/*,"tradePassword":tradePassword*/},
           type:"post",
           dataType:"json",
           success:function (map) {
               var client = map.accClient;
               var otherInfo = map.accOtherInfo;
               if(client!=null&&otherInfo!=null&&client.isClose==0&&client.tradePassword==pwd){
                   $("#acc_client_info").append("<form id=\"form_accClient_update\">\n" +
                       "        <table style=\"border-collapse:separate; border-spacing:0px 10px;\">\n" +
                       "            <tr>\n" +
                       "           <input type=\"hidden\" name=\"accAccount\" id=\"accAccount\">\n" +
                       "           <input type=\"hidden\" name=\"adminId\" id=\"adminId\">\n" +
                       "                <td><label>客户名称：</label><input  id=\"customerName\" type=\"text\" value=\"\" name=\"customerName\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>客户简称：</label><input id=\"customerReferred\" type=\"text\" value=\"\" name=\"customerReferred\"/></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>证件类型：</label><select id=\"certificateType\" name=\"certificateType\"  onload=\"SetValue()\">\n" +
                       "                    <option value=\"0\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                    <option value=\"1\">营业执照</option>\n" +
                       "                    <option value=\"2\">组织机构代码证</option>\n" +
                       "                    <option value=\"3\">税务登记证</option>\n" +
                       "                    <option value=\"4\">银行开户许可证</option>\n" +
                       "                    <option value=\"5\">银行贷款证</option>\n" +
                       "                    <option value=\"6\">统计登记证</option>\n" +
                       "                    <option value=\"7\">财政登记证</option>\n" +
                       "                    <option value=\"8\">对外贸易经营资格备案表</option>\n" +
                       "                    <option value=\"9\">海关报关注册登记证</option>\n" +
                       "                    <option value=\"10\">检验检疫备案证书</option>\n" +
                       "                    <option value=\"11\">外商投资企业批准证书</option>\n" +
                       "                    <option value=\"12\">消防安全生产许可证</option>\n" +
                       "                    <option value=\"13\">食品卫生许可证</option>\n" +
                       "                    <option value=\"14\">公共场所卫生许可证</option>\n" +
                       "                </select><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>证件号码：</label><input id=\"certificateNum\" type=\"text\" value=\"\" name=\"certificateNum\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>重复证件号码：</label><input id=\"certificateNum1\" type=\"text\" value=\"\" name=\"certificateNum1\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>证件有效期：</label><input id=\"certificateValidity\" type=\"date\" name=\"certificateValidity\"><span style=\"color:black;\">* </span><input name=\"certificateValidity1\"  type=\"checkbox\"  value=\"长期有效\" id=\"certificateValidity1\">长期有效</td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>邮政编码：</label><input id=\"postCode\" type=\"text\" value=\"\" name=\"postCode\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>联系电话：</label><input id=\"telphone1\" type=\"text\" value=\"\" name=\"telphone1\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "                <td><label>手机号码：</label><input id=\"phone\" type=\"text\" value=\"\" name=\"phone\"/></td>\n" +
                       "                <td><label>传真号码：</label><input id=\"faxNum1\" type=\"text\" value=\"\" name=\"faxNum1\"/></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>通讯地址：</label><input id=\"correspondenceAddress\" type=\"text\" value=\"\" name=\"correspondenceAddress\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>电子邮件：</label><input id=\"emailAddress\" type=\"text\" value=\"\" name=\"emailAddress\"/></td>\n" +
                       "            </tr>\n" +
                      /* "            <tr>\n" +
                       "                <td><label>对账单寄送方式：</label><select  >\n" +
                       "                    <option value=\"\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                </select></td>\n" +
                       "                <td><label>对账单寄送途径：</label><select>\n" +
                       "                    <option value=\"\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                </select></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>电话委托：</label><input type=\"checkbox\" name=\"\"></td>\n" +
                       "                <td><label>网上委托：</label><input type=\"checkbox\" name=\"\"></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>自助委托：</label><input type=\"checkbox\" name=\"\"></td>\n" +
                       "                <td><label>传真委托：</label><input type=\"checkbox\" name=\"commissionedByFacsimile\"></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>经纪人委托：</label><input type=\"checkbox\" name=\"\"></td>\n" +
                       "                <td><label>其他委托：</label><input type=\"checkbox\" name=\"\"></td>\n" +
                       "            </tr>\n" +*/
                       "            <tr>\n" +
                       "                <td><label>法人：</label><input id=\"legalPersonName\" type=\"text\" value=\"\" name=\"legalPersonName\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>法人证件：</label><select id=\"corporateDocumentType\" name=\"corporateDocumentType\">\n" +
                       "                    <option value=\"\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                </select><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>法人证件号码：</label><input id=\"corporateNumber\" type=\"text\" value=\"\" name=\"corporateNumber\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>法人证件有效期：</label><input id=\"legalPeriodOfLegalPerson\" type=\"date\" value=\"\" name=\"legalPeriodOfLegalPerson\"/><span style=\"color:black;\">* </span><input name=\"legalPeriodOfLegalPerson1\" type=\"checkbox\" value=\"长期有效\">长期有效</td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>组织机构代码：</label><input id=\"organizationCode\" type=\"text\" value=\"\" name=\"organizationCode\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>组织机构代码有效期：</label><input id=\"organizationCodeExpirationDate\" type=\"date\" value=\"\" name=\"organizationCodeExpirationDate\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>税务登记证号码：</label><input id=\"taxRegistrationNumber\" type=\"text\" value=\"\" name=\"organizationCode\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>负责人姓名：</label><input id=\"nameOfPersonInCharge\" type=\"text\" value=\"\" name=\"nameOfPersonInCharge\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>负责人证件类型：</label><select id=\"responsiblePersonType\" name=\"responsiblePersonType\">\n" +
                       "                    <option value=\"\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                </select></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>负责人证件号码：</label><input id=\"responsiblePersonNumber\" type=\"text\" value=\"\" name=\"responsiblePersonNumber\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>负责人证件号码有效期：</label><input id=\"principalValidityPeriod\" type=\"date\" value=\"\" name=\"principalValidityPeriod\"/><span style=\"color:black;\">* </span><input name=\"principalValidityPeriod1\" type=\"checkbox\" value=\"长期有效\">长期有效</td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>控股股东名称：</label><input id=\"controllingShareholderName\" type=\"text\" value=\"\" name=\"controllingShareholderName\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>控股股东类别：</label><select id=\"controllingShareholderType\" name=\"controllingShareholderType\" onload=\"SetV()\">\n" +
                       "                    <option value=\"0\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                    <option value=\"1\">绝对控股股东</option>\n" +
                       "                    <option value=\"2\">相对控股股东</option>\n" +
                       "                </select></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>控股股东证件类型：</label><select id=\"controllingShareholderTypeOfCertificate\" name=\"controllingShareholderTypeOfCertificate\">\n" +
                       "                    <option value=\"\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                </select></td>\n" +
                       "                <td><label>控股股东证件号码：</label><input id=\"controllingShareholderLicenseNumber\" type=\"text\" value=\"\" name=\"controllingShareholderLicenseNumber\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>控股股东证件有效期：</label><input id=\"controllingShareholderLicenseNumberTime\" type=\"date\" value=\"\" name=\"controllingShareholderLicenseNumberTime\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>经营范围：</label><input id=\"businessScope\" type=\"text\" value=\"\" name=\"businessScope\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>账户实际控制人：</label><input id=\"actualAccountController\" type=\"text\" value=\"\" name=\"actualAccountController\"/><span style=\"color:black;\">* </span></td>\n" +
                       "                <td><label>账户实际收益人：</label><input id=\"actualBeneficiaryOfTheAccount\" type=\"text\" value=\"\" name=\"actualBeneficiaryOfTheAccount\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>注册资本：</label><input id=\"registeredCapital\" type=\"text\" value=\"\" name=\"registeredCapital\"/><span style=\"color:black;\">* </span></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>控股股东税务登记账号：</label><input id=\"aTaxRegistrationCode\" type=\"text\" value=\"\" name=\"aTaxRegistrationCode\"/></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>控股股东组织代码证号：</label><input id=\"aOrganizationCodeNumber\" type=\"text\" value=\"\" name=\"aOrganizationCodeNumber\"/></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>行业：</label><select id=\"industryType\" name=\"industryType\">\n" +
                       "                    <option value=\"\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                </select></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><label>企业性质：</label><select id=\"natureOfBusiness\" name=\"natureOfBusiness\">\n" +
                       "                    <option value=\"\">&#45;&#45;请选择&#45;&#45;</option>\n" +
                       "                </select></td>\n" +
                       "            </tr>\n" +
                       "            <tr>\n" +
                       "                <td><input id=\"update_acc_client\" class=\"button\" type=\"button\" value=\"保存修改\" style=\"margin-left: 250px\" onclick=\"update()\"  /></td>\n" +
                       "                <td><input class=\"button\" type=\"button\" value=\"取消\" style=\"margin-left: 100px\" onclick=\"reset()\"></td>\n" +
                       "            </tr>\n" +
                       "        </table>\n" +
                       "    </form>")

                   if(client.certificateValidity=="长期有效"){
                       $("input[name='certificateValidity1']").prop("checked",true);
                       $("input[name='certificateValidity']").attr("disabled", "disabled");
                      $("input[name='certificateValidity1']").change(function () {
                           if ($("input[name='certificateValidity1']").prop("checked",false)) {
                               $("input[name='certificateValidity']").removeAttr("disabled");
                           }
                       })
                   }else{
                       $("input[name='certificateValidity1']").change(function () {
                           if ($("input[name='certificateValidity1']").prop("checked")) {
                               $("input[name='certificateValidity']").val("");
                               $("input[name='certificateValidity']").attr("disabled", "disabled");
                           } else {
                               $("input[name='certificateValidity']").removeAttr("disabled");
                           }
                       })
                   }

               if(otherInfo.legalPeriodOfLegalPerson=="长期有效"){
                   $("input[name='legalPeriodOfLegalPerson1']").prop("checked",true);
                   $("input[name='legalPeriodOfLegalPerson']").attr("disabled", "disabled");
                   $("input[name='legalPeriodOfLegalPerson1']").change(function () {
                       if ($("input[name='legalPeriodOfLegalPerson1']").prop("checked",false)) {
                           $("input[name='legalPeriodOfLegalPerson']").removeAttr("disabled");
                       }
                   })
               }else {
                   $("input[name='legalPeriodOfLegalPerson1']").change(function () {
                       if ($("input[name='legalPeriodOfLegalPerson1']").prop("checked")) {
                           $("input[name='legalPeriodOfLegalPerson']").val("");
                           $("input[name='legalPeriodOfLegalPerson']").attr("disabled", "disabled");
                       } else {
                           $("input[name='legalPeriodOfLegalPerson']").removeAttr("disabled");
                       }
                   })
               }


               if(otherInfo.principalValidityPeriod=="长期有效"){
                   $("input[name='principalValidityPeriod1']").prop("checked",true);
                   $("input[name='principalValidityPeriod']").attr("disabled", "disabled");
                   $("input[name='principalValidityPeriod1']").change(function () {
                       if ($("input[name='principalValidityPeriod1']").prop("checked",false)) {
                           $("input[name='principalValidityPeriod']").removeAttr("disabled");
                       }
                   })
               }else {
                   $("input[name='principalValidityPeriod1']").change(function () {
                       if ($("input[name='principalValidityPeriod1']").prop("checked")) {
                           $("input[name='principalValidityPeriod']").val("");
                           $("input[name='principalValidityPeriod']").attr("disabled", "disabled");
                       } else {
                           $("input[name='principalValidityPeriod']").removeAttr("disabled");
                       }
                   })
               }


               }else if (client!=null&&client.isClose==1&&pwd==client.tradePassword){
                   alert("机构信息已被销户！");
               }else if(client==null||otherInfo==null){
                   alert("交易账号错误！");
               }else if (pwd!=client.tradePassword){
                   alert("密码错误！");
               }

               //获得法人证件类型的默认值
               $.ajax({
                   url:"accClient/toAddDocuments",
                   type:"post",
                   dataType:"json",
                   success:function (json) {
                       var documents =json;
                       for (var i=0;i<documents.length;i++){
                           if(documents[i].documentsId==otherInfo.corporateDocumentType) {
                                $("#corporateDocumentType").append("<option value='"+documents[i].documentsId+"' selected='selected'>"+documents[i].documentsName+"</option>");
                           }else{
                               $("#corporateDocumentType").append("<option value='"+documents[i].documentsId+"'>"+documents[i].documentsName+"</option>");
                           }

                       }

                   }
               });

                //获得负责人证件类型
               $.ajax({
                   url:"accClient/toAddDocuments",
                   type:"post",
                   dataType:"json",
                   success:function (json) {
                       var documents =json;
                       for (var i=0;i<documents.length;i++){
                           if(documents[i].documentsId==otherInfo.responsiblePersonType) {
                               $("#responsiblePersonType").append("<option value='"+documents[i].documentsId+"' selected='selected'>"+documents[i].documentsName+"</option>");
                           }else{
                               $("#responsiblePersonType").append("<option value='"+documents[i].documentsId+"'>"+documents[i].documentsName+"</option>");
                           }

                       }

                   }
               });

                //获得控股股东证件类型的默认值
               $.ajax({
                   url:"accClient/toAddDocuments",
                   type:"post",
                   dataType:"json",
                   success:function (json) {
                       var documents =json;
                       for (var i=0;i<documents.length;i++){
                           if(documents[i].documentsId==otherInfo.controllingShareholderTypeOfCertificate) {
                               $("#controllingShareholderTypeOfCertificate").append("<option value='"+documents[i].documentsId+"' selected='selected'>"+documents[i].documentsName+"</option>");
                           }else{
                               $("#controllingShareholderTypeOfCertificate").append("<option value='"+documents[i].documentsId+"'>"+documents[i].documentsName+"</option>");
                           }

                       }

                   }
               });


               $("#accAccount").val(client.accAccount);
               $("#adminId").val(client.adminId);
               $("#customerName").val(client.customerName);
               $("#customerReferred").val(client.customerReferred);
               $("#certificateType").val(client.certificateType);
               $("#certificateNum").val(client.certificateNum);
               $("#certificateNum1").val(client.certificateNum);
               $("#certificateValidity").val(client.certificateValidity);
               $("#postCode").val(client.postCode);
               $("#telphone1").val(client.telphone1);
               $("#phone").val(client.phone);
               $("#faxNum1").val(client.faxNum1);
               $("#correspondenceAddress").val(client.correspondenceAddress);
               $("#emailAddress").val(client.emailAddress);
               $("#legalPersonName").val(otherInfo.legalPersonName);
               $("#corporateNumber").val(otherInfo.corporateNumber);
               $("#legalPeriodOfLegalPerson").val(otherInfo.legalPeriodOfLegalPerson);
               $("#organizationCode").val(otherInfo.organizationCode);
               $("#organizationCodeExpirationDate").val(otherInfo.organizationCodeExpirationDate);
               $("#taxRegistrationNumber").val(otherInfo.taxRegistrationNumber);
               $("#nameOfPersonInCharge").val(otherInfo.nameOfPersonInCharge);
               $("#responsiblePersonType").val(otherInfo.responsiblePersonType);
               $("#responsiblePersonNumber").val(otherInfo.responsiblePersonNumber);
               $("#principalValidityPeriod").val(otherInfo.principalValidityPeriod);
               $("#controllingShareholderName").val(otherInfo.controllingShareholderName);
               $("#controllingShareholderLicenseNumber").val(otherInfo.controllingShareholderLicenseNumber);
               $("#controllingShareholderLicenseNumberTime").val(otherInfo.controllingShareholderLicenseNumberTime);
               $("#businessScope").val(otherInfo.businessScope);
               $("#actualAccountController").val(otherInfo.actualAccountController);
               $("#actualBeneficiaryOfTheAccount").val(otherInfo.actualBeneficiaryOfTheAccount);
               $("#registeredCapital").val(otherInfo.registeredCapital);
               $("#aTaxRegistrationCode").val(otherInfo.aTaxRegistrationCode);
               $("#aOrganizationCodeNumber").val(otherInfo.aOrganizationCodeNumber);
               $("#").val();
               $("#").val();


           }

       });
   });
        //获取证件类型的默认值
   function SetValue(value) {
       var certiSel=document.getElementById("certificateType");
       var opt=document.createElement("option");
       for (var i = 0; i < certiSel.options.length; i++) {
           if (certiSel.options[i].value == value) {
               document.getElementById("certificateType").selectedIndex = i;
               $(opt).val(document.getElementById("certificateType").selectedIndex);
               $(opt).text(document.getElementById("certificateType").selectedIndex);
           }
       }
   }

        //获得控股股东类别的默认值
    function SetV(value) {
        var controSel=document.getElementById("controllingShareholderType");
        var opt=document.createElement("option");
        for (var j = 0; j < controSel.options.length; j++) {
            if (controSel.options[j].value == value) {
                document.getElementById("controllingShareholderType").selectedIndex = j;
                $(opt).val(document.getElementById("controllingShareholderType").selectedIndex);
                $(opt).text(document.getElementById("controllingShareholderType").selectedIndex);
            }
        }
    }

function  update() {
         //保存机构信息的修改
        var data =$("#form_accClient_update").serialize();
        $.ajax({
            url:"accClient/updateInfo",
            data:data,
            type:"post",
            dataType:"json",
            success:function (i) {
                if(i>0){
                    alert("修改资料成功！");
                    window.location.href="/toIndex2";
                }else {
                    alert("修改失败");
                }

            }
        });
}

function reset() {
 $("#acc_client_info").remove();
}

