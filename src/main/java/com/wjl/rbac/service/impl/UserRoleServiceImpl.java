package com.wjl.rbac.service.impl;

import com.wjl.rbac.entity.User;
import com.wjl.rbac.entity.UserRole;
import com.wjl.rbac.repository.UserRoleRepository;
import com.wjl.rbac.service.intf.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/11/15 19:02
 * @version: v1.0
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findRolesByUser(User user) {
        return userRoleRepository.findAllByUid(user.getId());
    }

}
