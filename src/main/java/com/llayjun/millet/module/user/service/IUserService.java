package com.llayjun.millet.module.user.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llayjun.millet.module.user.entity.User;

public interface IUserService extends IService<User> {

    List<User> findAll();
}
