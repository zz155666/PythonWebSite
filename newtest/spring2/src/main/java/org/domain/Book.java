package org.domain;

import java.io.Serializable;

/**
 * @ProjectName: spring2
 * @Package: org.domain
 * @ClassName: Book
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/8/29 20:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}
