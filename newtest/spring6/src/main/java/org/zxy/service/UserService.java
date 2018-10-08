package org.zxy.service;

import org.zxy.domain.User;

public interface UserService {
        User login(String loginname,String password);
}
