package org.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: spring2
 * @Package: org.domain
 * @ClassName: Employee
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/3 21:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Dept> depts;

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

}
