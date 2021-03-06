package com.yundian.imc.service.impl;

import com.yundian.imc.common.base.BaseServiceImpl;
import com.yundian.imc.dao.UserDao;
import com.yundian.imc.entity.User;
import com.yundian.imc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserDao userDao;
}
