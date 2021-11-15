package com.wjl.rbac.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.wjl.rbac.entity.User;
import com.wjl.rbac.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wjl
 * @date: 2021/11/15 19:30
 * @version: v1.0
 */
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (userService.findUserByUsernameAndPassword(username, password) != null) {
            StpUtil.login(username);
            user.setToken(StpUtil.getTokenValue());
            return "success";
        } else {
            return "failed";
        }
    }

}
