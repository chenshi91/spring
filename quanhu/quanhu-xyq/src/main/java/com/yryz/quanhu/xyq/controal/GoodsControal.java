/* created by chenshi at 2018-04-28 */
package com.yryz.quanhu.xyq.controal;

import com.yryz.quanhu.xyq.entity.Goods;
import com.yryz.quanhu.xyq.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/xyq")
public class GoodsControal {
    @Autowired
    private IGoodsService   goodsService;

    /**
     * list列表
     * @param model
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String   m1(Model model){
        List<Goods> list = goodsService.selectAll();
        model.addAttribute("list",list);
        return "xyq/goodsList";
    }

    /**
     * 添加/修改
     * @param goods
     * @param bindingResult
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@Valid Goods goods, BindingResult bindingResult, Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            model.addAttribute("message",message);
            return "xyq/updatePrize";
        }
        if (goods.getId()==null) {
            goodsService.insert(goods);
            model.addAttribute("message","添加"+goods.getName()+"成功！");
            return m1(model);
        }
        goodsService.update(goods);
        model.addAttribute("message","修改"+goods.getName()+"成功！");
        return m1(model);
    }

    /**
     * 跳转到添加页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/toUpdate/{id}", method = RequestMethod.GET)
    public String   selectById(Model model,@PathVariable("id") Long id){
        Goods goods = goodsService.selectById(id);
        model.addAttribute("entity",goods);
        return "/xyq/updatePrize";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.POST})
    public String delete(@PathVariable("id") Long id)  {
        Goods goods = goodsService.selectById(id);
        if (goods==null) {
            return "数据不存在，操作有误";
        }else {
            goodsService.delete(id);
            return "deleteOk";
        }
    }
}
