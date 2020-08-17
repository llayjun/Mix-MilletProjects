package com.llayjun.millet.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.llayjun.millet.common.entity.Result;
import com.llayjun.millet.module.user.dto.UserDTO;
import com.llayjun.millet.module.user.entity.User;
import com.llayjun.millet.module.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "测试文字接口", notes = "测试文字接口", hidden = true)
    public String hello() {
        return "hello , this is a spring boot";
    }

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @PostMapping("/userLogin")
    public Result<User> userLogin(@Validated @RequestBody UserDTO userDTO) {
        // 判断是否存在重复的手机号
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getMobile, userDTO.getMobile());
        int count = userService.count(wrapper);
        if (count <= 0) {
            return new Result<User>().genFail("用户不存在");
        }
        wrapper.eq(User::getPassWord, userDTO.getPassWord());
        User user = userService.getOne(wrapper);
        if (user == null) {
            return new Result<User>().genFail("用户密码错误");
        }
        return new Result<User>().genSuccessData(user);
    }

    @ApiOperation(value = "注册用户", notes = "注册用户")
    @PostMapping("/register")
    public Result<User> registerUser(@Validated @RequestBody User user) {
        // 判断是否存在重复的手机号
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getMobile, user.getMobile());
        int count = userService.count(wrapper);
        if (count > 0) {
            return new Result<User>().genFail("已经存在该手机号");
        }
        boolean state = userService.save(user);
        if (!state) {
            return new Result<User>().genFail("注册失败");
        }
        return new Result<User>().genSuccessData(user);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/delete/{id}")
    public Result<User> deleteUser(@PathVariable String id) {
        if (!judgeUserExist(id)) {
            return new Result<User>().genFail("该用户不存在");
        }
        boolean state = userService.removeById(id);
        if (!state) {
            return new Result<User>().genFail("删除失败");
        }
        return new Result<User>().genSuccess("删除成功");
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("/change")
    public Result<User> insertUser(@Validated @RequestBody User user) {
        boolean state = userService.updateById(user);
        if (!state) {
            return new Result<User>().genFail("更新失败");
        }
        return new Result<User>().genSuccessData(user);
    }

    @ApiOperation(value = "获取指定用户信息", notes = "获取指定用户信息")
    @GetMapping("/findUserInfo/{id}")
    public Result<User> findUserInfo(@PathVariable String id){
        if (!judgeUserExist(id)) {
            return new Result<User>().genFail("该用户不存在");
        }
        return new Result<User>().genSuccessData(userService.getById(id));
    }

    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    @GetMapping("/findAll")
    public Result<List<User>> findAll(){
        return new Result<List<User>>().genSuccessData(userService.findAll());
    }

    /**
     * 判断用户是否存在
     * @param id
     * @return
     */
    public boolean judgeUserExist(String id) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getId, id);
        int count = userService.count(wrapper);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

}
