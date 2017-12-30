/**Created	by	chenshi  at	2017年12月26日 下午5:30:48*/
package com.quanhu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.quanhu.entity.User;

/**
 * @description:	UserRowMapper.java
 * @packageName:	com.quanhu.dao
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		
		return new	User(rs.getLong(1), rs.getString(2), rs.getString(3));
	}

}
