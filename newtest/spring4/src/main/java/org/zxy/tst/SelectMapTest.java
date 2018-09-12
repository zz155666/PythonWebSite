package org.zxy.tst;

import org.apache.ibatis.session.SqlSession;
import org.zxy.domain.User;
import org.zxy.factory.FKSqlSessionFactory;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: spring4
 * @Package: org.zxy.tst
 * @ClassName: SelectMapTest
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/12 21:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SelectMapTest {

    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            sqlSession= FKSqlSessionFactory.getSqlSession();
            List<Map<String,Object>> list =sqlSession.selectList("org.zxy.mapper.UserMapper.selectUserMap");
            list.forEach(row-> System.out.println(row));
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
