package com.wjl.rbac.service.intf;

import com.wjl.rbac.entity.Role;
import com.wjl.rbac.entity.RolePermission;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/11/15 19:04
 * @version: v1.0
 */
public interface RolePermissionService {

    List<RolePermission> findAllByRole(Role role);

}
