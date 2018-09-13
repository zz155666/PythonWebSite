package org.zxy.tst;

import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.zxy.domain.Person;
import org.zxy.factory.FKSqlSessionFactory;
import org.zxy.factory.GsonFactory;
import org.zxy.mapper.PersonMapper;

/**
 * @ProjectName: spring4
 * @Package: org.zxy.tst
 * @ClassName: OneToOneTest
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/13 20:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OneToOneTest {

    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            sqlSession= FKSqlSessionFactory.getSqlSession();
            PersonMapper mp=sqlSession.getMapper(PersonMapper.class);
            Person p=mp.selectPersonById(1);
            GsonFactory.tojson(p);
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
