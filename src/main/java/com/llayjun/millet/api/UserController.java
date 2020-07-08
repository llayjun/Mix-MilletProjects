package com.llayjun.millet.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.llayjun.millet.common.entity.Result;
import com.llayjun.millet.module.user.dto.UserDTO;
import com.llayjun.millet.module.user.entity.User;
import com.llayjun.millet.module.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.llayjun.millet.common.constant.Constants.APP_URI_V1;

/**
 * @author yinleizhang
 */
@RestController
@Api(tags = "用户管理接口")
@RequestMapping(APP_URI_V1 + "/users")
@EnableAutoConfiguration
public class UserController {

    @GetMapping("/hello")
    @ApiOperation(value = "测试文字接口", notes = "测试文字接口")
    public String hello() {
        return "hello , this is a spring boot, haha";
    }

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "注册用户", notes = "注册用户")
    @PostMapping("/register")
    public Result<String> insertUser(@Validated @RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        // 判断是否存在重复的手机号
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getMobile, user.getMobile());
        int count = userService.count(wrapper);
        if (count > 0) {
            return new Result<String>().genFail("已经存在该手机号");
        }
        boolean state = userService.save(user);
        if (!state) {
            return new Result<String>().genFail("注册失败");
        }
        return new Result<String>().genSuccess("注册成功");
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("/change/{id}")
    public Result<String> insertUser(@PathVariable String id, @Validated @RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setId(id);
        boolean state = userService.updateById(user);
        if (!state) {
            return new Result<String>().genFail("更新失败");
        }
        return new Result<String>().genSuccess("更新成功");
    }

    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    @GetMapping("/findAll")
    public Result<List<User>> findAll(){
        return new Result<List<User>>().genSuccessData(userService.findAll());
    }

}
