package com.yundian.imc.service;

import com.yundian.imc.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);
    List<User> getUsers();
    User find(Long id);
}