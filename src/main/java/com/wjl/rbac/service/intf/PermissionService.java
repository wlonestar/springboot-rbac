package com.wjl.rbac.service.intf;

import com.wjl.rbac.entity.Permission;

/**
 * @author: wjl
 * @date: 2021/11/15 19:00
 * @version: v1.0
 */
public interface PermissionService {

    Permission fnidPermissionById(Long pid);

}
