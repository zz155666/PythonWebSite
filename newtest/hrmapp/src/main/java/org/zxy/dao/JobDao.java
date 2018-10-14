package org.zxy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.zxy.dao.provider.JobDynaSqlProvider;
import org.zxy.domain.Job;

import java.util.List;
import java.util.Map;

import static org.zxy.util.common.HrmConstants.JOBTABLE;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.dao
 * @ClassName: JobDao
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/13 12:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface JobDao {

    @Select("select * from "+JOBTABLE+" where ID = #{id}")
    Job selectById(int id);

    @Select("select * from "+JOBTABLE+" ")
    List<Job> selectAllJob();

    // 动态查询
    @SelectProvider(type= JobDynaSqlProvider.class,method="selectWhitParam")
    List<Job> selectByPage(Map<String, Object> params);

    @SelectProvider(type=JobDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    // 根据id删除部门
    @Delete(" delete from "+JOBTABLE+" where id = #{id} ")
    void deleteById(Integer id);

    // 动态插入部门
    @SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
    void save(Job job);

    // 动态修改用户
    @SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
    void update(Job job);

}
