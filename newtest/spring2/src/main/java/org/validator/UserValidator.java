package org.validator;

import org.domain.User5;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @ProjectName: spring2
 * @Package: org.validator
 * @ClassName: UserValidator
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/4 20:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User5.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"username",null,"用户名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"sex",null,"性别不能为空");
        ValidationUtils.rejectIfEmpty(errors,"age",null,"年龄不能为空");
    }
}
