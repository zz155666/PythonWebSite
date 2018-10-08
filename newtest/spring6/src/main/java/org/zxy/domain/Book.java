package org.zxy.domain;

import java.util.Date;

public class Book {

    private static final long serialVersionUID = 1L;

    private Integer id;				// id
    private String name;			// 书名
    private String author;			// 作者
    private String publication;		// 出版社
    private Date publicationdate;	// 出版日期
    private Double price;			// 价格
    private String image;			// 封面图片
    private String remark;			// 详细描述

    public Book() {
        super();
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
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublication() {
        return publication;
    }
    public void setPublication(String publication) {
        this.publication = publication;
    }
    public Date getPublicationdate() {
        return publicationdate;
    }
    public void setPublicationdate(Date publicationdate) {
        this.publicationdate = publicationdate;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author
                + ", publication=" + publication + ", publicationdate="
                + publicationdate + ", price=" + price + ", image=" + image
                + ", remark=" + remark + "]";
    }

}
