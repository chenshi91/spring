package com.yryz.quanhu.shiro.realm;

import com.yryz.quanhu.shiro.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义relam
 * @author Administrator
 *
 */
public class CustomerRealm  extends AuthorizingRealm {

	
	
	
	//授权的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		//获取身份信息
		String username = (String) token.getPrincipal();
		System.out.println(username);
		if("张三".equals(username)){
			User userDB = new User("12","张三","123456");
			/**
			 * 参数一:身份信息
			 * 参数二:凭证信息
			 * 参数三:reaml 名字  不写有默认值
			 */
			AuthenticationInfo authenticationInfo 
			= new SimpleAuthenticationInfo(userDB.getName(), userDB.getPassword(), this.getName());
			return authenticationInfo;
		}
		return null;
	}

}
