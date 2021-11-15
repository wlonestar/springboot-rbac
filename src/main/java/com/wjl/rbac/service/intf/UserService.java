package com.wjl.rbac.service.intf;

import com.wjl.rbac.entity.User;

/**
 * @author: wjl
 * @date: 2021/11/15 18:58
 * @version: v1.0
 */
public interface UserService {

    User findUserById(Long id);

    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

}
