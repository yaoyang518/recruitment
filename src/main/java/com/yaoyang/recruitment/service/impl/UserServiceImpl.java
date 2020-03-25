package com.yaoyang.recruitment.service.impl;

import com.yaoyang.recruitment.entity.User;
import com.yaoyang.recruitment.enumeration.EntityStatus;
import com.yaoyang.recruitment.repository.UserRepository;
import com.yaoyang.recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }


    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        user.setUpdateDate(new Date());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        user.setUpdateDate(new Date());
        user.setEntityStatus(EntityStatus.DELETE);
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findByLoginNameAndPassword(String loginName, String password) {
        return userRepository.findByLoginNameAndPassword(loginName,password);
    }

}
