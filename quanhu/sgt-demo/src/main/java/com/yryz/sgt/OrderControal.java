/*create by chens at 2018-04-21  */
package com.yryz.sgt;

import com.quanhu.base.exception.ControllerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sound.midi.ControllerEventListener;

/**
 * description:
 */
@RequestMapping(value = "/sgt")
@Controller
public class OrderControal {

    @RequestMapping(value = {"/demo"},method = RequestMethod.GET)
    public String   user(Model model){
        model.addAttribute("userName","徐家立");
        if (1==1) {
            throw new ControllerException("问问也UR与个乳液UR也UR也UR有");
        }
        return "sgt";
    }
}
