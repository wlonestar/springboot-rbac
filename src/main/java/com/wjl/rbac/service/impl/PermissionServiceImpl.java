package com.wjl.rbac.service.impl;

import com.wjl.rbac.entity.Permission;
import com.wjl.rbac.repository.PermissionRepository;
import com.wjl.rbac.service.intf.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wjl
 * @date: 2021/11/15 19:01
 * @version: v1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission fnidPermissionById(Long pid) {
        return permissionRepository.findPermissionById(pid);
    }

}
