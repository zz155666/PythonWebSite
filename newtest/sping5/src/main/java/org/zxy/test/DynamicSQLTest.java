package org.zxy.test;

import org.apache.ibatis.session.SqlSession;
import org.zxy.Mapper.ClazzMapper;
import org.zxy.Mapper.EmployMapper;
import org.zxy.domain.Clazz;
import org.zxy.domain.Employee;
import org.zxy.factory.FKSqlSessionFactory;

import java.util.*;

public class DynamicSQLTest {

    public static void main(String[] args) {
        // 定义SqlSession变量
        SqlSession sqlSession = null;
        try {
            // 创建SqlSession实例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            EmployMapper cm=sqlSession.getMapper(EmployMapper.class);
            DynamicSQLTest t=new DynamicSQLTest();
            t.testSelectWhitParam(cm);
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

    public void testSelectWhitParam(EmployMapper em){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("loginname","jack");
        map.put("password","11111");
        List<Employee> list=em.selectWhitParam(map);
        System.out.println(list);
    }

}
