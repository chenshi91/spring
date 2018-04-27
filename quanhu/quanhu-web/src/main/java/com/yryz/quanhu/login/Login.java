/**
 * 
 */
package com.yryz.quanhu.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 *
 */
@Controller
public class Login {
	
	@RequestMapping(value="/login2",method={RequestMethod.GET})
	public String login(String username,String password){
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(new UsernamePasswordToken(username, password));
		} catch (UnknownAccountException e) {
			System.out.println("账号错误");
			e.printStackTrace();
		}catch (IncorrectCredentialsException e) {
			System.out.println("密码错误");
			e.printStackTrace();
		}catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return "easyUIDay1";
	}
}
