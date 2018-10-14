package org.zxy.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zxy.dao.provider.EmployeeDynaSqlProvider;
import org.zxy.domain.Employee;

import java.util.List;
import java.util.Map;

import static org.zxy.util.common.HrmConstants.EMPLOYEETABLE;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.dao
 * @ClassName: EmployeeDao
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/13 12:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface EmployeeDao {
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method="count")
    Integer count(Map<String,Object> params);

    @SelectProvider(type=EmployeeDynaSqlProvider.class,method = "selectWhitParam")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "CARD_ID",property = "cardId"),
            @Result(column = "POST_CODE",property = "postCode"),
            @Result(column = "QQ_NUM",property = "qqNum"),
            @Result(column = "BIRTHDAY",property = "birthday",javaType = java.util.Date.class),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "DEPT_ID",property = "dept",one = @One(select = "org.zxy.dao.DeptDao.selectById",fetchType = FetchType.EAGER)),
            @Result(column="JOB_ID",property="job", one=@One(select="org.zxy.dao.JobDao.selectById", fetchType=FetchType.EAGER))
    })
    List<Employee> selectByPage(Map<String,Object> params);

    // 动态插入员工
    @SelectProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
    void save(Employee employee);

    // 根据id删除员工
    @Delete(" delete from "+EMPLOYEETABLE+" where id = #{id} ")
    void deleteById(Integer id);

    // 根据id查询员工
    @Select("select * from "+EMPLOYEETABLE+" where ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="CARD_ID",property="cardId"),
            @Result(column="POST_CODE",property="postCode"),
            @Result(column="QQ_NUM",property="qqNum"),
            @Result(column="BIRTHDAY",property="birthday",javaType=java.util.Date.class),
            @Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
            @Result(column="DEPT_ID",property="dept",
                    one=@One(select="org.zxy.dao.DeptDao.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="JOB_ID",property="job",
                    one=@One(select="org.zxy.dao.JobDao.selectById",
                            fetchType=FetchType.EAGER))
    })
    Employee selectById(Integer id);

    // 动态修改员工
    @SelectProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
    void update(Employee employee);
}
