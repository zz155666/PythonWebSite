package org.zxy.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import org.zxy.domain.Notice;

import java.util.Map;

import static org.zxy.util.common.HrmConstants.NOTICETABLE;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.dao.provider
 * @ClassName: NoticeDynaSqlProvider
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/13 15:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NoticeDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(NOTICETABLE);
                if(params.get("notice") != null){
                    Notice notice = (Notice)params.get("notice");
                    if(notice.getTitle() != null && !notice.getTitle().equals("")){
                        WHERE("  title LIKE CONCAT ('%',#{notice.title},'%') ");
                    }
                    if(notice.getContent() != null && !notice.getContent().equals("")){
                        WHERE("  content LIKE CONCAT ('%',#{notice.content},'%') ");
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
                FROM(NOTICETABLE);
                if(params.get("notice") != null){
                    Notice notice = (Notice)params.get("notice");
                    if(notice.getTitle() != null && !notice.getTitle().equals("")){
                        WHERE("  title LIKE CONCAT ('%',#{notice.title},'%') ");
                    }
                    if(notice.getContent() != null && !notice.getContent().equals("")){
                        WHERE("  content LIKE CONCAT ('%',#{notice.content},'%') ");
                    }
                }
            }
        }.toString();
    }
    // 动态插入
    public String insertNotice(Notice notice){

        return new SQL(){
            {
                INSERT_INTO(NOTICETABLE);
                if(notice.getTitle() != null && !notice.getTitle().equals("")){
                    VALUES("title", "#{title}");
                }
                if(notice.getContent() != null && !notice.getContent().equals("")){
                    VALUES("content", "#{content}");
                }
                if(notice.getUser() != null && notice.getUser().getId() != null){
                    VALUES("user_id", "#{user.id}");
                }
            }
        }.toString();
    }
    // 动态更新
    public String updateNotice(Notice notice){

        return new SQL(){
            {
                UPDATE(NOTICETABLE);
                if(notice.getTitle() != null && !notice.getTitle().equals("")){
                    SET(" title = #{title} ");
                }
                if(notice.getContent() != null && !notice.getContent().equals("")){
                    SET(" content = #{content} ");
                }
                if(notice.getUser() != null && notice.getUser().getId() != null){
                    SET(" user_id = #{user.id} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }

}
