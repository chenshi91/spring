import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class TestShiro {
	
	/**
	 * 用户认证流程:
	 * 	1.根据用户名密码创建token
	 *  2.调用subject的login(token),直接找subject实现类DelegatingSubject的login方法(token),
	 *  	在DelegatingSubject的login方法中去掉用securityManager里面的login(token),
	 *  	会调用DefaultSecurityManager的login(token),在DefaultSecurityManager的login方法中
	 *  	会调用这个类ModularRealmAuthenticator中的authenticate(token),这个类会验证用户的身份信息(用户名),凭证信息(密码)
	 *  	如果找到对应的用户信息返回AuthenticationInfo对象如果对象不为空认证成功
	 */
	@Test
	public  void testAuthenticate(){
		
		//通过ini配置文件创建安全管理器工厂
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory();
		
		//通过工厂获取安全管理器
		SecurityManager securityManager = factory.getInstance();
		
		//把安全管理器注入到安全工具类中
		SecurityUtils.setSecurityManager(securityManager);
		//获取主体
		Subject subject = SecurityUtils.getSubject();
		
		//认证
		AuthenticationToken token = new UsernamePasswordToken("zhangsan", "123456");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		//获取认证状态
		System.out.println(subject.isAuthenticated());
		
	}
	
	
	@Test
	public  void testAuthenticate_customerReaml(){
		
		//通过ini配置文件创建安全管理器工厂
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		
		//通过工厂获取安全管理器
		SecurityManager securityManager = factory.getInstance();
		
		//把安全管理器注入到安全工具类中
		SecurityUtils.setSecurityManager(securityManager);
		//获取主体
		Subject subject = SecurityUtils.getSubject();
		
		//认证
		AuthenticationToken token = new UsernamePasswordToken("张三", "123456");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		//获取认证状态
		System.out.println(subject.isAuthenticated());
		
	}
	
	
	
	
	
	
	
}
