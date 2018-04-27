/**
 * 
 */
package com.yryz.quanhu.login;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 *
 */
@Controller
public class EasyuiControal {
	
	@RequestMapping(value="/chi",method=RequestMethod.GET)
	public void m1(HttpServletResponse response) throws IOException, InterruptedException{
		Thread.sleep(2000);
		response.setCharacterEncoding("utf-8");
		Writer writer = response.getWriter();
		writer.write("<strong>我吃了，你呢？</strong>");
	}
}
