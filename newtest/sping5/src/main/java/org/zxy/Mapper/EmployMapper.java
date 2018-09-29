package org.zxy.Mapper;

import org.apache.ibatis.annotations.SelectProvider;
import org.zxy.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployMapper {
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "selectWhitParam")
    List<Employee> selectWhitParam(Map<String,Object> param);
}
