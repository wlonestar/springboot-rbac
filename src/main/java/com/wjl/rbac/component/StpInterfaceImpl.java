package com.wjl.rbac.component;

import cn.dev33.satoken.stp.StpInterface;
import com.wjl.rbac.entity.*;
import com.wjl.rbac.service.intf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: wjl
 * @date: 2021/11/15 19:31
 * @version: v1.0
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<String> getPermissionList(Object loginId, String s) {
        User user = userService.findUserByUsername(loginId.toString());
        List<UserRole> userRoles = userRoleService.findRolesByUser(user);
        Set<String> permissions = new HashSet<>();
        for (UserRole userRole : userRoles) {
            Role role = roleService.findRoleById(userRole.getRid());
            List<RolePermission> rolePermissions = rolePermissionService.findAllByRole(role);
            for (RolePermission rolePermission : rolePermissions) {
                Permission permission = permissionService.fnidPermissionById(rolePermission.getPid());
                permissions.add(permission.getPermission());
            }
        }
        return new ArrayList<>(permissions);
    }

    @Override
    public List<String> getRoleList(Object loginId, String s) {
        List<UserRole> userRoles = userRoleService.findRolesByUser(userService.findUserByUsername(loginId.toString()));
        List<String> roles = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            roles.add(roleService.findRoleById(userRole.getRid()).getRole());
        }
        return roles;
    }

}
