package com.yundian.imc.dao;

import com.yundian.imc.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
}
