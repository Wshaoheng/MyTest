    /*var financialStatus =null;
    var proportionAssets =null;
    var AnnualIncome = null;
    var InvestmentHorizon = null;
    var investmentInTime = null;
    var total = null;*/

function sub() {

        /*var fins =document.getElementsByName("financialStatus");
        for(var i=0;i<fins.length;i++){
            if(fins[i].checked){
                alert(fins[i].value);
                financialStatus =fins[i].value;
            }
        }

        var ppa = document.getElementsByName("proportionAssets");
        for(var i=0;i<ppa.length;i++){
            if(ppa[i].checked){
                proportionAssets =ppa[i].value;
            }
        }

        var ai = document.getElementsByName("AnnualIncome");
        for(var i=0;i<ai.length;i++){
            if(ai[i].checked){
                AnnualIncome =ai[i].value;
            }
        }

        var ith = document.getElementsByName("InvestmentHorizon");
        for(var i=0;i<ith.length;i++){
            if(ith[i].checked){
                InvestmentHorizon =ith[i].value;
            }
        }

        var iit = document.getElementsByName("investmentInTime");
        for(var i=0;i<iit.length;i++){
            if(iit[i].checked){
                investmentInTime =iit[i].value;
            }
        }*/

        var financialStatus =$("input[name='financialStatus']:checked").val();
        var proportionAssets =$("input[name='proportionAssets']:checked").val();
        var AnnualIncome =$("input[name='AnnualIncome']:checked").val();
        var InvestmentHorizon =$("input[name='InvestmentHorizon']:checked").val();
        var investmentInTime =$("input[name='investmentInTime']:checked").val();

   var total =Number(financialStatus)+Number(proportionAssets)+Number(AnnualIncome)+Number(InvestmentHorizon)+Number(investmentInTime);


    $.ajax({
        url:"/accClient/toAddScore",
        data:{"total":total},
        type:"post",
        dataType:"json",
        success:function (i) {
            if(i>0){
                window.location.href="/fund/gou";
            }else {
                alert("提交失败");
            }
        }
    });

}