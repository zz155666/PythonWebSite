package org.zxy.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import org.zxy.domain.Job;

import java.util.Map;

import static org.zxy.util.common.HrmConstants.JOBTABLE;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.dao.provider
 * @ClassName: JobDynaSqlProvider
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/13 12:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class JobDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(JOBTABLE);
                if(params.get("job") != null){
                    Job job = (Job) params.get("job");
                    if(job.getName() != null && !job.getName().equals("")){
                        WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
                    }
                }
            }
        }.toString();

        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }

        return sql;
    }
    // 动态查询总数量
    public String count(Map<String, Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(JOBTABLE);
                if(params.get("job") != null){
                    Job job = (Job) params.get("job");
                    if(job.getName() != null && !job.getName().equals("")){
                        WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
                    }
                }
            }
        }.toString();
    }
    // 动态插入
    public String insertJob(Job job){

        return new SQL(){
            {
                INSERT_INTO(JOBTABLE);
                if(job.getName() != null && !job.getName().equals("")){
                    VALUES("name", "#{name}");
                }
                if(job.getRemark() != null && !job.getRemark().equals("")){
                    VALUES("remark", "#{remark}");
                }
            }
        }.toString();
    }
    // 动态更新
    public String updateJob(Job job){

        return new SQL(){
            {
                UPDATE(JOBTABLE);
                if(job.getName() != null){
                    SET(" name = #{name} ");
                }
                if(job.getRemark() != null){
                    SET(" remark = #{remark} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }

}
