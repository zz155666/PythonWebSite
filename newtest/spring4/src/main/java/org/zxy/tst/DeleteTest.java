package org.zxy.tst;

import org.apache.ibatis.session.SqlSession;
import org.zxy.domain.User;
import org.zxy.factory.FKSqlSessionFactory;

/**
 * @ProjectName: spring4
 * @Package: org.zxy.tst
 * @ClassName: DeleteTest
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/12 21:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DeleteTest {

    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            sqlSession= FKSqlSessionFactory.getSqlSession();
            sqlSession.delete("org.zxy.mapper.UserMapper.removeUser",8);
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
