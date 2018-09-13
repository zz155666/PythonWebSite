package org.zxy.tst;

import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.zxy.domain.Student;
import org.zxy.domain.User;
import org.zxy.factory.FKSqlSessionFactory;

import java.util.List;

public class SelectStudentTest {

    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            sqlSession= FKSqlSessionFactory.getSqlSession();
            List<Student> students=sqlSession.selectList("org.zxy.mapper.UserMapper.selectStudent");
            Gson gson=new Gson();
            System.out.println(gson.toJson(students));
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
