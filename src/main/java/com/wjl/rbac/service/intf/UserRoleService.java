package com.wjl.rbac.service.intf;

import com.wjl.rbac.entity.User;
import com.wjl.rbac.entity.UserRole;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/11/15 19:02
 * @version: v1.0
 */
public interface UserRoleService {

    List<UserRole> findRolesByUser(User user);

}
