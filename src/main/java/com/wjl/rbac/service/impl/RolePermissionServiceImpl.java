package com.wjl.rbac.service.impl;

import com.wjl.rbac.entity.Role;
import com.wjl.rbac.entity.RolePermission;
import com.wjl.rbac.repository.RolePermissionRepository;
import com.wjl.rbac.service.intf.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/11/15 19:05
 * @version: v1.0
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService  {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<RolePermission> findAllByRole(Role role) {
        return rolePermissionRepository.findAllByRid(role.getId());
    }

}
