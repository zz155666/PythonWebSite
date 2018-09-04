package org.domain;

import java.io.Serializable;

public class User4  implements Serializable {

    private static final long serialVersionUID = 1L;

    // 部门编号
    private Integer deptId;

    public User4() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

}
