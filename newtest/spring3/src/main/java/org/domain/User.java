package org.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: spring3
 * @Package: org.domain
 * @ClassName: User
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/6 22:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String loginname;
    private Date birthday;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User [loginname=" + loginname + ", birthday=" + birthday + "]";
    }

}
