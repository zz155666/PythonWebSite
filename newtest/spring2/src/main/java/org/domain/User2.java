package org.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: spring2
 * @Package: org.domain
 * @ClassName: User2
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/2 21:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean reader;
    private List<String> courses;

    public User2() {
        super();
    }


    public boolean isReader() {
        return reader;
    }


    public void setReader(boolean reader) {
        this.reader = reader;
    }


    public List<String> getCourses() {
        return courses;
    }


    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

}
