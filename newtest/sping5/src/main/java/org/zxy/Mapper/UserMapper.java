package org.zxy.Mapper;

import org.apache.ibatis.annotations.*;
import org.zxy.domain.User;

import java.util.List;

/**
 * @ProjectName: sping5
 * @Package: org.zxy.Mapper
 * @ClassName: UserMapper
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/18 21:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UserMapper {

    @Insert("INSERT INTO TB_USER(name,sex,age) VALUES (#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveUser(User user);

    @Delete("DELETE FROM TB_USER WHERE id = #{id}")
    int removeUser(@Param("id") Integer id);

    @Update("UPDATE TB_USER SET name = #{name},sex = #{sex},age = #{age} WHERE id = #{id}")
    void modifyUser(User user);

    @Select("SELECT * FROM TB_USER WHERE id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    User selectUserById(@Param("id") Integer id);

    @Select("SELECT * FROM TB_USER ")
    List<User> selectAllUser();
}
