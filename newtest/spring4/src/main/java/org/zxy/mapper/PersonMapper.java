package org.zxy.mapper;

import org.zxy.domain.Person;

/**
 * @ProjectName: spring4
 * @Package: org.zxy.mapper
 * @ClassName: PersonMapper
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/13 20:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface PersonMapper {
    Person selectPersonById(Integer id);
}
