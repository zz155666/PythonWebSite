package org.zxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zxy.domain.User;
import org.zxy.mapper.UserMapper;
import org.zxy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String loginname, String password) {
        return userMapper.findWithLoginnameAndPassword(loginname,password);
    }
}
