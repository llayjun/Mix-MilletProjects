package com.llayjun.millet.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.common.utils.JwtTokenUtil;
import com.llayjun.millet.module.user.dto.UserLoginDTO;
import com.llayjun.millet.module.user.dto.UserRegisterDTO;
import com.llayjun.millet.module.user.entity.User;
import com.llayjun.millet.module.user.service.IUserService;
import com.llayjun.millet.module.user.vo.UserVO;
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
    @ApiOperation(value = "测试文字接口", notes = "测试文字接口", hidden = true)
    public String hello() {
        return "hello , this is a spring boot";
    }

    @Autowired
    private IUserService userService;

    /**
     * 用户登录接口
     * @param userLoginDTO
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @PostMapping("/userLogin")
    public BaseResult<UserVO> userLogin(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        // 判断是否存在重复的手机号
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getMobile, userLoginDTO.getMobile());
        int count = userService.count(wrapper);
        if (count <= 0) {
            return BaseResult.error("用户不存在");
        }
        wrapper.eq(User::getPassWord, userLoginDTO.getPassWord());
        User user = userService.getOne(wrapper);
        if (user == null) {
            return BaseResult.error("用户密码错误");
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        String token = JwtTokenUtil.buildJWTToken(user.getId());
        userVO.setAuthorization(token);
        return BaseResult.success(userVO);
    }

    /**
     * 用户注册接口
     * @param userRegisterDTO
     * @return
     */
    @ApiOperation(value = "注册用户", notes = "注册用户")
    @PostMapping("/register")
    public BaseResult<User> registerUser(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        // 判断是否存在重复的手机号
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getMobile, userRegisterDTO.getMobile());
        int count = userService.count(wrapper);
        if (count > 0) {
            return BaseResult.error("已经存在该手机号");
        }
        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        boolean state = userService.save(user);
        if (!state) {
            return BaseResult.error("注册失败");
        }
        return BaseResult.success(user);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/delete/{id}")
    public BaseResult<User> deleteUser(@PathVariable String id) {
        if (judgeUserNotExist(id)) {
            return BaseResult.error("该用户不存在");
        }
        boolean state = userService.removeById(id);
        if (!state) {
            return BaseResult.error("删除失败");
        }
        return BaseResult.success("删除成功");
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("/change")
    public BaseResult<User> insertUser(@Validated @RequestBody User user) {
        boolean state = userService.updateById(user);
        if (!state) {
            return BaseResult.error("更新失败");
        }
        return BaseResult.success(user);
    }

    /**
     * 获取指定用户信息
     * @param id
     * @return
     */
    @ApiOperation(value = "获取指定用户信息", notes = "获取指定用户信息")
    @GetMapping("/findUserInfo/{id}")
    public BaseResult<User> findUserInfo(@PathVariable String id){
        if (judgeUserNotExist(id)) {
            return BaseResult.error("该用户不存在");
        }
        return BaseResult.success(userService.getById(id));
    }

    /**
     * 获取所有用户
     * @return
     */
    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    @GetMapping("/findAll")
    public BaseResult<List<User>> findAll(){
        return BaseResult.success(userService.findAll());
    }

    /**
     * 判断用户是否存在
     * @param id
     * @return
     */
    public boolean judgeUserNotExist(String id) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getId, id);
        int count = userService.count(wrapper);
        return count <= 0;
    }

}
