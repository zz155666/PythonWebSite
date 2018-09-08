package org.converter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: spring3
 * @Package: org.converter
 * @ClassName: DateEditor
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 9:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String  text) throws IllegalArgumentException{
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date=dateFormat.parse(text);
            setValue(date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
