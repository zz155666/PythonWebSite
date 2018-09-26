package org.zxy.test;

import org.apache.ibatis.session.SqlSession;
import org.zxy.Mapper.PersonMapper;
import org.zxy.Mapper.UserMapper;
import org.zxy.domain.Person;
import org.zxy.domain.User;
import org.zxy.factory.FKSqlSessionFactory;

public class OneToOneTest {

    public static void main(String[] args) {
        // 定义SqlSession变量
        SqlSession sqlSession = null;
        try {
            // 创建SqlSession实例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            PersonMapper pm=sqlSession.getMapper(PersonMapper.class);
            Person p=pm.selectPersonById(2);
            System.out.println(p);
            System.out.println(p.getCard());
            // 提交事务
            sqlSession.commit();
        } catch (Exception e) {
            // 回滚事务
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            // 关闭SqlSession
            if(sqlSession != null)
                sqlSession.close();
        }
    }

}
