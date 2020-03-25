package com.yaoyang.recruitment.repository;

import com.yaoyang.recruitment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByLoginNameAndPassword(String loginName,String password);

}
