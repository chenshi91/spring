/**Created	by	chenshi  at	2017年12月22日 下午8:33:21*/
package yuanli;

/**
 * @description:	UserServiceImpl.java
 * @packageName:	yuanli
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UserServiceImpl implements UserService {

	/* 
	 * @see yuanli.UserService#login()
	 */
	@Override
	public void login() {
		System.out.println("userService--------login");
	}

	/* 
	 * @see yuanli.UserService#regist()
	 */
	@Override
	public void regist() {
		System.out.println("userService--------regist");
	}

}
