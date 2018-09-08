package org.binding;

import org.converter.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.util.Date;

/**
 * @ProjectName: spring3
 * @Package: org
 * @ClassName: DateBindingInitializer
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 10:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DateBindingInitializer  implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,new DateEditor());
    }
}
