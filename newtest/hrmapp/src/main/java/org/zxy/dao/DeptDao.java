package org.zxy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.zxy.dao.provider.DeptDynaSqlProvider;
import org.zxy.domain.Dept;

import java.util.List;
import java.util.Map;

import static org.zxy.util.common.HrmConstants.DEPTTABLE;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.dao
 * @ClassName: DeptDao
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/13 11:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface DeptDao {

    @SelectProvider(type= DeptDynaSqlProvider.class,method="selectWhitParam")
    List<Dept> selectByPage(Map<String, Object> params);

    @SelectProvider(type=DeptDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    @Select("select * from "+DEPTTABLE+" ")
    List<Dept> selectAllDept();

    @Select("select * from "+DEPTTABLE+" where ID = #{id}")
    Dept selectById(int id);

    // 根据id删除部门
    @Delete(" delete from "+DEPTTABLE+" where id = #{id} ")
    void deleteById(Integer id);

    // 动态插入部门
    @SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
    void save(Dept dept);

    // 动态修改用户
    @SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
    void update(Dept dept);

}


