package org.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: spring3
 * @Package: org.domain
 * @ClassName: User2
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 13:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

public class User2 implements Serializable {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NumberFormat(style = NumberFormat.Style.NUMBER,pattern = "#,###")
    private int total;
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double discount;
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double money;


    public User2() {
        super();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User [birthday=" + birthday + ", total=" + total
                + ", discount=" + discount + ", money=" + money + "]";
    }
}
