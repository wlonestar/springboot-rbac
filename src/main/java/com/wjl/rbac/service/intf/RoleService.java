package com.wjl.rbac.service.intf;

import com.wjl.rbac.entity.Role;

/**
 * @author: wjl
 * @date: 2021/11/15 18:59
 * @version: v1.0
 */
public interface RoleService {

    Role findRoleById(Long rid);

}
