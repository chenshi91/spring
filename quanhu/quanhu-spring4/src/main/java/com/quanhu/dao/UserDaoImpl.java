/**Created	by	chenshi  at	2017年12月26日 下午5:07:25*/
package com.quanhu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.quanhu.entity.User;

/**
 * @description:	UserDaoImpl.java
 * @packageName:	com.quanhu.dao
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UserDaoImpl  implements UserDao {
	
	/***/
	private static final String SELECT_BY_USERNAME_AND_PASSWORD = "select id,user_name,pass_word from test_user where user_name=? and pass_word=?";
	/***/
	private static final String UPDATE_USER = "update test_user set user_name=? , pass_word=? where id=?";
	/***/
	private static final String DELETE_USER = "delete from test_user where id=?";
	/***/
	private static final String INSERT_USER = "insert into test_user(id,user_name,pass_word) values(null,?,?)";
	JdbcTemplate	jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void insert(User user) {
		jdbcTemplate.update(INSERT_USER, user.getUserName(),user.getPassWord());
	}
	
	
	/* 
	 * @see com.quanhu.dao.UserDao#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		jdbcTemplate.update(DELETE_USER,id);
	}

	/* 
	 * @see com.quanhu.dao.UserDao#update(com.quanhu.entity.User)
	 */
	@Override
	public void update(User user) {
		jdbcTemplate.update(UPDATE_USER, user.getUserName(),user.getPassWord(),user.getId());
	}

	/* 
	 * @see com.quanhu.dao.UserDao#selectByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User selectByUsernameAndPassword(String userName, String passWord) {
		return jdbcTemplate.queryForObject(SELECT_BY_USERNAME_AND_PASSWORD, new UserRowMapper(),userName,passWord);
	}

	/* 
	 * @see com.quanhu.dao.UserDao#listByPage(java.lang.Byte, java.lang.Byte)
	 */
	@Override
	public List<User> listByPage(Byte pageNo, Byte pageSize) {
		return	jdbcTemplate.query("select id,user_name,pass_word from test_user limit ?,?", new UserRowMapper(),(pageNo-1)*pageSize,pageSize);
	}

}
