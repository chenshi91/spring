/**Created	by	chenshi  at	2017年12月21日 下午4:27:52*/
package mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yryz.quanhu.topic.dao.TopicDao;
import com.yryz.quanhu.topic.entity.Topic;

/**
 * @description:	MybatisTest.java
 * @packageName:	mybatis.test
 * @projectName:	quanhu-mybatis
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MybatisTest {
	
	public static void main(String[] args) throws IOException {
		/**1,创建sqlSessionFactoryBuilder对象,读取核心配置文件*/
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		/**2,sqlSessionFactory*/
		Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		
		/**3,获取sqlSession*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		/**4,使用sqlSession,获取dao对象*/
		TopicDao topicDao = sqlSession.getMapper(TopicDao.class);
		
		/**5,调用dao接口*/
		Topic topic = topicDao.selectById(336L);
		System.out.println(topic);
		
		/**6,提交事务*/
		sqlSession.commit();
		
		/**7,关闭session*/
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
}
