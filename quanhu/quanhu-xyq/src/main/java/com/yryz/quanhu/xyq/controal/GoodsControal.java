/* created by chenshi at 2018-04-28 */
package com.yryz.quanhu.xyq.controal;

import com.yryz.quanhu.xyq.entity.Goods;
import com.yryz.quanhu.xyq.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/xyq")
public class GoodsControal {
    @Autowired
    private IGoodsService   goodsService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String   m1(Model model){
        List<Goods> list = goodsService.selectAll();
        model.addAttribute("list",list);
        return "xyq/goodsList";
    }
}
