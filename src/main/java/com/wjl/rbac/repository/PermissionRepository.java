package com.wjl.rbac.repository;

import com.wjl.rbac.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wjl
 * @date: 2021/11/15 18:55
 * @version: v1.0
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findPermissionById(Long id);

}
