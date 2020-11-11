package com.llayjun.millet.module.user.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llayjun.millet.module.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface IUserService extends IService<User> {

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> findAll();
}
