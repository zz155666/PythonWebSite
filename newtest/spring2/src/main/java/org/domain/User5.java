package org.domain;

import java.io.Serializable;

/**
 * @ProjectName: spring2
 * @Package: org.domain
 * @ClassName: User5
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/4 20:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User5 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String sex;
    private Integer age;

    public User5() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
