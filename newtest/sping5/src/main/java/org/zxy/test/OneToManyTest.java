package org.zxy.test;

import org.apache.ibatis.session.SqlSession;
import org.zxy.Mapper.ClazzMapper;
import org.zxy.Mapper.PersonMapper;
import org.zxy.domain.Clazz;
import org.zxy.domain.Person;
import org.zxy.factory.FKSqlSessionFactory;

public class OneToManyTest {


    public static void main(String[] args) {
        // 定义SqlSession变量
        SqlSession sqlSession = null;
        try {
            // 创建SqlSession实例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            ClazzMapper cm=sqlSession.getMapper(ClazzMapper.class);
            Clazz clazz=cm.selectById(1);
            System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
            // 查看关联的学生集合，因为配置使用的是LAZY懒加载，所以当使用时才执行SQL语句
            clazz.getStudents().forEach(student->System.out.println(student));
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
