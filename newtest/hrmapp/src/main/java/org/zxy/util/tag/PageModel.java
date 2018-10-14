package org.zxy.util.tag;

import org.zxy.util.common.HrmConstants;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.util.tag
 * @ClassName: PageModel
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/14 10:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PageModel {
    //分页总数据
    private int recordCount;
    //当前页面
    private int pageIndex;
    //每页多少数据
    private int pageSize= HrmConstants.PAGE_DEFAULT_SIZE=4;
    //总页数
    private int totalSize;

    public int getRecordCount() {
        this.recordCount = this.recordCount <= 0 ? 0:this.recordCount;
        return recordCount;
    }
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageIndex() {
        this.pageIndex = this.pageIndex <= 0?1:this.pageIndex;
        /** 判断当前页面是否超过了总页数:如果超过了默认给最后一页作为当前页  */
        this.pageIndex = this.pageIndex>=this.getTotalSize()?this.getTotalSize():this.pageIndex;

        return pageIndex;
    }
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
    public int getPageSize() {
        this.pageSize = this.pageSize <= HrmConstants.PAGE_DEFAULT_SIZE?HrmConstants.PAGE_DEFAULT_SIZE:this.pageSize;
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        if(this.getRecordCount() <=0){
            totalSize = 0 ;
        }else{
            totalSize = (this.getRecordCount() -1)/this.getPageSize() + 1;
        }
        return totalSize;
    }


    public int getFirstLimitParam(){
        return (this.getPageIndex()-1)*this.getPageSize() ;
    }

}
