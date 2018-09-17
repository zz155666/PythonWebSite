package org.zxy.mapper;

import org.zxy.domain.Student;

public interface StudentMapper {
    Student selectStudentById(Integer id);
}
