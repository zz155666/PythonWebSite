package org.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: spring3
 * @Package: org.converter
 * @ClassName: StringToDateConverter
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/7 21:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StringToDateConverter implements Converter<String, Date> {

    private String datePattern;

    public void setDatePattern(String datePattern){
        this.datePattern=datePattern;
    }

    @Override
    public Date convert(String date) {
        try {
            SimpleDateFormat dateFormat=new SimpleDateFormat(this.datePattern);
            return dateFormat.parse(date);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("日期转换失败");
            return null;
        }
    }
}
