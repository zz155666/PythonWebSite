package org.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ProjectName: spring3
 * @Package: org.formatter
 * @ClassName: DateFormatter
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 10:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DateFormatter implements Formatter<Date> {

    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern){
        this.dateFormat=new SimpleDateFormat(datePattern);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        try{
            return dateFormat.parse(text);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }
}
