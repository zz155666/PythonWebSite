package org.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: spring2
 * @Package: org.domain
 * @ClassName: User3
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/2 21:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User3 implements Serializable {

    private List<String> cources;
    public User3(){
        super();
    }
    public List<String> getCources(){
        return this.cources;
    }
    public void setCources(List<String> cources){
        this.cources=cources;
    }
}
