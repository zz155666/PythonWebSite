package org.zxy.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zxy.dao.provider.NoticeDynaSqlProvider;
import org.zxy.domain.Notice;

import java.util.List;
import java.util.Map;

import static org.zxy.util.common.HrmConstants.NOTICETABLE;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.dao
 * @ClassName: NoticeDao
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/13 15:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface NoticeDao {

    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "selectWhitParam")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "USER_ID",property = "user",one = @One(select = "org.zxy.dao.UserDao.selectById",fetchType = FetchType.EAGER))
    })
    List<Notice> selectByPage(Map<String,Object> params);

    @SelectProvider(type=NoticeDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    @Select("select * from "+NOTICETABLE+" where ID = #{id}")
    Notice selectById(int id);

    // 根据id删除公告
    @Delete(" delete from "+NOTICETABLE+" where id = #{id} ")
    void deleteById(Integer id);

    // 动态插入公告
    @SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
    void save(Notice notice);

    // 动态修改公告
    @SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
    void update(Notice notice);

}
