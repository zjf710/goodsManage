package com.springboot.goodsManage.controller;

import com.springboot.goodsManage.dao.UserDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.framwork.BaseController;
import com.springboot.goodsManage.model.User;
import com.springboot.goodsManage.model.result.Result;
import com.springboot.goodsManage.model.result.ResultUtil;
import com.springboot.goodsManage.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserDao userDao;

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result setUserInfo(@RequestBody Map<String,Object> userInfoMap) throws BusinessException{

        String msg = new UserService(userDao, new User()).setUserInfo(userInfoMap);

        return ResultUtil.success(msg);
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,Object> userInfoMap) throws BusinessException{

        String msg = new UserService(userDao, new User()).login(userInfoMap);

        return ResultUtil.success(msg);
    }

    //
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public Result changePassword(@RequestBody Map<String,Object> userInfoMap) throws BusinessException{

        String msg = new UserService(userDao, new User()).changePassword(userInfoMap);

        return ResultUtil.success(msg);
    }

    @RequestMapping("/getAllStudent")
    public List<User> getAllStudent(){
        Logger.getGlobal().info("info111");
        return userDao.findAll();
    }
}
