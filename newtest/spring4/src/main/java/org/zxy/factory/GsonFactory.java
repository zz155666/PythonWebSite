package org.zxy.factory;

import com.google.gson.Gson;

/**
 * @ProjectName: spring4
 * @Package: org.zxy.factory
 * @ClassName: GsonFactory
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/13 20:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GsonFactory {
    public static String tojson(Object o){
        Gson gson=new Gson();
        System.out.println(gson.toJson(o));
        return gson.toJson(o);
    }
}
