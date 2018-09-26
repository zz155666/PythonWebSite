package org.zxy.Mapper;

import org.apache.ibatis.annotations.Select;
import org.zxy.domain.Card;

public interface CardMapper {
    @Select("SELECT * FROM TB_CARD WHERE ID=#{id}")
    Card selectCardById(Integer id);
}
