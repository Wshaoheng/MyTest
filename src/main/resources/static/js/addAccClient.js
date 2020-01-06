    //   $(function () {
            $("#form-btn").click(function () {
                alert(1234);
                var url ="accClient/addAccClient";
                var data =$("#form_accClient").serialize();
                $.ajax({
                    url:url,
                    data:data,
                    type:"POST",
                    dataType:"json",
                    success:function (json) {
                        if(json.state==200){
                            alert("开户成功！");
                        }
                    }
                });
           });
      //  });