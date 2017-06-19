package com.yundian.imc.dao;

import com.yundian.imc.common.base.BaseDao;
import com.yundian.imc.entity.User;

public interface UserDao extends BaseDao<User,Long> {
    User findUserByUsername(String username);
}
