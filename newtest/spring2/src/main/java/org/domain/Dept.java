package org.domain;

import java.io.Serializable;

/**
 * @ProjectName: spring2
 * @Package: org.domain
 * @ClassName: Dept
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/3 21:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Dept implements Serializable {

    private Integer id;
    private String name;

    public Dept(){
        super();
    }
    public Dept(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



}
