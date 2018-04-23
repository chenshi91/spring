package com.yryz.quanhu.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthorizingRealm{
    //授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		return null;
	}
    //认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//获取用户名
		String username=(String)token.getPrincipal();
        //从数据库中获取的密码
		String password = "64646ce0014ba59b5a200d461c24c8a2";
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), password, ByteSource.Util.bytes(username), getName());
		return info;
	}
}
