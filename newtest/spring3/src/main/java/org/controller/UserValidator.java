package org.controller;

import org.domain.User3;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @ProjectName: spring3
 * @Package: org.validator
 * @ClassName: UserValidator
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 14:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Repository("userValidator")
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User3.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"loginname",null,"登录名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"密码不能为空");
        User3 user=(User3)target;
        if(user.getLoginname().length()>10){
            errors.rejectValue("loginname",null,"用户名不能超过10个字符");
        }
        if(user.getPassword()!=null&&!user.getPassword().equals("")&&user.getPassword().length()<6){
                errors.rejectValue("password",null,"密码不能小于6位");
        }
    }
}
