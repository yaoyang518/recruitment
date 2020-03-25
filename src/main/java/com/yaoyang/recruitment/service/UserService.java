package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.User;

public interface UserService {

    User findById(Long id);

    User save(User user);

    User update(User user);

    void delete(User user);

    User findByLoginNameAndPassword(String loginName, String password);


}
