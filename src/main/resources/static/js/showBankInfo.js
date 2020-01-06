$(function () {
            $.ajax({
                url:"findAllAcBankName",
                type:"get",
                dateType:"json",
                success:function (json){
                    var bankNameList = json;
                    for(var i=0;i<bankNameList.length;i++){
                       $("#seBank").append("<option value='"+bankNamrList[i].bankId+"'>"+bankNamrList[i].bankName+"</option>");

                    }
                }

            });
});