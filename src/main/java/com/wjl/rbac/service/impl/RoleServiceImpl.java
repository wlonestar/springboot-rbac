package com.wjl.rbac.service.impl;

import com.wjl.rbac.entity.Role;
import com.wjl.rbac.repository.RoleRepository;
import com.wjl.rbac.service.intf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wjl
 * @date: 2021/11/15 18:59
 * @version: v1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleById(Long rid) {
        return roleRepository.findRoleById(rid);
    }

}
