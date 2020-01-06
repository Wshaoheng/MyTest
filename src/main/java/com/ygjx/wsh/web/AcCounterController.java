package com.ygjx.wsh.web;

import com.ygjx.wsh.entity.AcCounter;
import com.ygjx.wsh.service.IAcCounterService;
import com.ygjx.wsh.util.Result;
import com.ygjx.wsh.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 柜台表的控制器层
 */
@Controller
@RequestMapping("/acCounter")
public class AcCounterController {

    @Autowired
    private IAcCounterService acCounterService;

    @RequestMapping("/addAcCounter")
    @ResponseBody
    public Result add(AcCounter counter){
        acCounterService.create(counter);
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);

        return result;
    }

}
