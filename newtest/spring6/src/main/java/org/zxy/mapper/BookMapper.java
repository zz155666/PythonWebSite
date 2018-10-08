package org.zxy.mapper;

import org.apache.ibatis.annotations.Select;
import org.zxy.domain.Book;

import java.util.List;

public interface BookMapper {
    @Select("select * from tb_newbook")
    List<Book> findAll();
}
