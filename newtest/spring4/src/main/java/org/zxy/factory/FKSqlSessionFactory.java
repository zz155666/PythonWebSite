package org.zxy.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @ProjectName: spring4
 * @Package: org.zxy.factory
 * @ClassName: FKSqlSessionFactory
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/11 21:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FKSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory=null;

    static {
        try (
                InputStream is= Resources.getResourceAsStream("mybatis-config.xml")
                ){
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
