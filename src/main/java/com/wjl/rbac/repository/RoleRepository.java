package com.wjl.rbac.repository;

import com.wjl.rbac.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wjl
 * @date: 2021/11/15 18:54
 * @version: v1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long id);

}
