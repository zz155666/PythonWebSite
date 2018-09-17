package org.zxy.tst;

import org.apache.ibatis.session.SqlSession;
import org.zxy.domain.Clazz;
import org.zxy.domain.Student;
import org.zxy.factory.FKSqlSessionFactory;
import org.zxy.mapper.ClazzMapper;
import org.zxy.mapper.StudentMapper;

public class OneToManyTest {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            sqlSession= FKSqlSessionFactory.getSqlSession();
//            ClazzMapper cm=sqlSession.getMapper(ClazzMapper.class);
//            Clazz clazz=cm.selectClazzById(1);
//            System.out.println(clazz.getId());
//            System.out.println(clazz.getCode());
//            clazz.getStudents().forEach(stu->System.out.println(stu));

            StudentMapper sm=sqlSession.getMapper(StudentMapper.class);
            Student student=sm.selectStudentById(1);
            System.out.println(student);
            System.out.println(student.getClazz());

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
