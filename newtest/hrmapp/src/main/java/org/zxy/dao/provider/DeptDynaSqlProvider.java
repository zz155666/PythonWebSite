package org.zxy.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import org.zxy.domain.Dept;

import java.util.Map;

import static org.zxy.util.common.HrmConstants.DEPTTABLE;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.dao.provider
 * @ClassName: DeptDynaSqlProvider
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/11 21:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DeptDynaSqlProvider {

    public String selectWhitParam(Map<String,Object> params){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM(DEPTTABLE);
                if(params.get("dept")!=null){
                    Dept dept=(Dept)params.get("dept");
                    if(dept.getName()!=null&&!dept.getName().equals("")){
                        WHERE("  name LIKE CONCAT ('%',#{dept.name},'%')  ");
                    }
                }
            }
        }.toString();
        if(params.get("pageModel")!=null){
            sql+="  limit #{pageModel.firstLimitParam},#{pageModel.pageSize} ";
        }
        return  sql;
    }


    public String count(Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(DEPTTABLE);
                if(params.get("dept")!=null){
                    Dept dept=(Dept)params.get("dept");
                    if(dept.getName()!=null&&!dept.getName().equals("")){
                        WHERE(" name LIKE CONCAT ('%',#{dept.name},'%') ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertDept(Dept dept){

        return new SQL(){
            {
                INSERT_INTO(DEPTTABLE);
                if(dept.getName() != null && !dept.getName().equals("")){
                    VALUES("name", "#{name}");
                }
                if(dept.getRemark() != null && !dept.getRemark().equals("")){
                    VALUES("remark", "#{remark}");
                }
            }
        }.toString();
    }
    // 动态更新
    public String updateDept(Dept dept){

        return new SQL(){
            {
                UPDATE(DEPTTABLE);
                if(dept.getName() != null){
                    SET(" name = #{name} ");
                }
                if(dept.getRemark() != null){
                    SET(" remark = #{remark} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }


}
