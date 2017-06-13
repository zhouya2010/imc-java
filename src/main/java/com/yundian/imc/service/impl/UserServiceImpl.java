package com.yundian.imc.service.impl;

import com.yundian.imc.dao.UserDao;
import com.yundian.imc.entity.User;
import com.yundian.imc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User add(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        return toList(userDao.findAll());
    }

    @Override
    public User find(Long id) {
        return userDao.findOne(id);
    }

    private <E> List<E> toList(Iterable<E> i) {
        List<E> list = new ArrayList<>();
        i.forEach(list::add);
        return list;
    }
}
