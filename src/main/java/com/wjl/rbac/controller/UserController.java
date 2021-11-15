package com.wjl.rbac.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpInterface;
import com.wjl.rbac.component.StpInterfaceImpl;
import com.wjl.rbac.service.intf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/11/15 19:53
 * @version: v1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private StpInterface stpInterface;

    @SaCheckLogin
    @SaCheckRole("admin")
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<String> getAllRoles(@RequestParam String username) {
        return stpInterface.getRoleList(username, "user");
    }

    @SaCheckRole("visitor")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public List<String> getAllPermissions(@RequestParam String username) {
        return stpInterface.getPermissionList(username, "admin");
    }

}
