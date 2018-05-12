/**
 * 
 */
package com.yryz.quanhu.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Properties;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletResponse;

import com.quanhu.base.utils.PropertiesUtil;
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

	public static void main(String[] args) throws IOException {
		System.out.println(PropertiesUtil.getPropertiesValue("topic", "content"));
	}
}
