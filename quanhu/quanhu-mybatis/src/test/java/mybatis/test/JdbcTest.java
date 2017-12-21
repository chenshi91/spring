/**Created	by	chenshi  at	2017年12月21日 下午5:05:12*/
package mybatis.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description:	JdbcTest.java
 * @packageName:	mybatis.test
 * @projectName:	quanhu-mybatis
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class JdbcTest {
	
	public static void main(String[] args){  
	        Connection connection = null;  
	        ResultSet rs = null;  
	        PreparedStatement stmt = null;  
	        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();  
	          
	        try {  
	            //加载JDBC驱动  
	            Class.forName("com.mysql.jdbc.Driver").newInstance();  
	            String url = "jdbc:mysql://localhost:3306/quanhu";  
	              
	            String user = "root";   
	            String password = "392485362";   
	              
	            //获取数据库连接  
	            connection = DriverManager.getConnection(url,user,password);   
	              
	            String sql = "select id,title,content,img_url from yryz_topic where id = ? ";  
	            //创建Statement对象（每一个Statement为一次数据库执行请求）  
	            stmt = connection.prepareStatement(sql);  
	              
	            //设置传入参数  
	            stmt.setString(1, "336");  
	              
	            //执行SQL语句  
	            rs = stmt.executeQuery();  
	              
	            //处理查询结果（将查询结果转换成List<Map>格式）  
	            ResultSetMetaData rsmd = rs.getMetaData();  
	            int num = rsmd.getColumnCount();  
	              
	            while(rs.next()){  
	                Map<String,Object> map = new HashMap<String,Object>(2);  
	                for(int i = 0;i < num;i++){  
	                    String columnName = rsmd.getColumnName(i+1);  
	                    map.put(columnName,rs.getString(columnName));  
	                }  
	                resultList.add(map);  
	            }  
	              
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                   //关闭结果集  
	                if (rs != null) {  
	                    rs.close();  
	                    rs = null;  
	                }  
	                   //关闭执行  
	                if (stmt != null) {  
	                    stmt.close();  
	                    stmt = null;  
	                }  
	                if (connection != null) {  
	                    connection.close();  
	                    connection = null;  
	                }  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        System.out.println(resultList.get(0).entrySet().toString());  
	    }
}
