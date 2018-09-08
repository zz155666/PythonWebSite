package org.domain;

import java.io.Serializable;

/**
 * @ProjectName: spring3
 * @Package: org.domain
 * @ClassName: User3
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 13:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String loginname;
    private String password;

    public User3() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [loginname=" + loginname + ", password=" + password + "]";
    }

}
