        var client=null;
        var pwd =null;

    function getAccClient() {
         pwd = $("#pwd").val();
        var count = $("#account").val();
        var data = count;
       /* var tradePassword = pwd;*/

        $.ajax({
            url: "accClient/toEditInfo",
            data: {"accAccount": data/*, "tradePassword": tradePassword*/},
            type: "post",
            dataType: "json",
            success: function (map) {
                if(map.accClient!=null&&map.accOtherInfo!=null){
                    client = map.accClient;
                }else{
                    alert("交易账号错误！");
                }

            }

        });
    }


         function abc() {
             if (client.isClose!= 1) {

             if (pwd != client.tradePassword) {
                 alert("密码错误！");
             } else {

                 $('select>option').each(function () {
                     if (client.certificateType == $(this).val()) {
                         $("#select").val(client.certificateType);
                     }
                 });


                 var num = prompt("请输入" + $("#select").find("option:selected").text() + "号码: ", "");
                 if (num != "") {
                     if (num == client.certificateNum) {
                         $.ajax({
                             url: "accClient/accClientClose?isClose=" + 1 + "&accAccount=" + client.accAccount,
                             type: "get",
                             dateType: "json",
                             success: function (i) {
                                 if (i > 0) {
                                     alert("销户成功！");
                                     window.location.href = "/toIndex2";
                                 } else {
                                     alert("销户失败！");
                                 }
                             }
                         });
                     }/*else{
                alert("证件信息有误！");
            }*/

                 } else {
                     alert("请输入证件信息！")
                 }
             }
         }else{
                 alert("该机构信息已经被注销！")
             }
         }









        /*var aclient ="";
            function getAccClient(){

                if($("#account").val()!=""&&$("#account").val()!=null) {

                    $.ajax({
                        url: "accClient/getAccClient?accAccount="+$("#account").val(),
                        type: "get",
                        dataType: "json",
                        success: function (client) {
                            if(client!=""&&client!=null) {
                                 aclient = client;
                            }
                        }

                    });
                }
            }*/