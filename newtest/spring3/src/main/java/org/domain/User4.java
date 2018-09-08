package org.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: spring3
 * @Package: org.domain
 * @ClassName: User4
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 15:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User4 implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String loginname;

    @NotBlank
    @Length(min=6,max=8)
    private String password;

    @NotBlank
    private String username;

    @Range(min=15, max=60)
    private int age;

    @Email
    private String email;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past
    private Date birthday;

    @Pattern(regexp="[1][3,8][3,6,9][0-9]{8}")
    private String phone;


    public User4() {
        super();
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


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "User [loginname=" + loginname + ", password=" + password
                + ", email=" + email + ", username="
                + username + ", birthDate=" + birthday + ", phone=" + phone
                + "]";
    }

}
