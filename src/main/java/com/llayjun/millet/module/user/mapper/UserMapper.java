package com.llayjun.millet.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llayjun.millet.module.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();
}
