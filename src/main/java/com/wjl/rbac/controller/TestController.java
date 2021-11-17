package com.wjl.rbac.controller;

import com.wjl.rbac.entity.*;
import com.wjl.rbac.service.intf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 *
 * @author: wjl
 * @date: 2021/11/15 19:08
 * @version: v1.0
 */
@RestController
public class TestController {

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

    /**
     * hello
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    /**
     * user
     *
     * @param username username
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User findUserByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }

    /**
     * role
     *
     * @param id id
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public Role findRoleById(@RequestParam Long id) {
        return roleService.findRoleById(id);
    }

    /**
     * permission
     *
     * @param id id
     */
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public Permission findPermissionById(@RequestParam Long id) {
        return permissionService.fnidPermissionById(id);
    }

    /**
     * user's role
     *
     * @param username username
     */
    @RequestMapping(value = "/user/role", method = RequestMethod.GET)
    public List<UserRole> findRolesByUser(@RequestParam String username) {
        return userRoleService.findRolesByUser(userService.findUserByUsername(username));
    }

    @Deprecated
    @RequestMapping(value = "/permission/user", method = RequestMethod.GET)
    public List<Permission> findPermissionsByUser(@RequestParam String username) {
        User user = userService.findUserByUsername(username);
        List<UserRole> userRoles = userRoleService.findRolesByUser(user);
        List<Permission> permissions = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            Role role = roleService.findRoleById(userRole.getRid());
            List<RolePermission> rolePermissions = rolePermissionService.findAllByRole(role);
            for (RolePermission rolePermission : rolePermissions) {
                Permission permission = permissionService.fnidPermissionById(rolePermission.getPid());
                permissions.add(permission);
            }
        }
        return permissions;
    }

}
