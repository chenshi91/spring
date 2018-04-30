/* created by chenshi at 2018-04-30 */
package com.yryz.quanhu.demo.controal;

import com.yryz.quanhu.demo.entity.Demo;
import com.yryz.quanhu.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/demo")
public class DemoControal {
    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping(value = "",method = {RequestMethod.GET})
    public List<Demo> list(){
        List<Demo> list = demoService.selectAll();
        return list;
    }
}
