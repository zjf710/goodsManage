package com.springboot.goodsManage.service;

import com.springboot.goodsManage.dao.UserDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.User;

import java.util.List;
import java.util.Map;

public class UserService {

    private UserDao userDao;
    private User user;

    public UserService(UserDao userDao, User user) {
        this.userDao = userDao;
        this.user = user;
    }

    // 注册
    public String setUserInfo(Map<String, Object> userInfoMap) throws BusinessException {

        if (!userInfoMap.containsKey("mobile") || !userInfoMap.containsKey("password")) {
            throw new BusinessException("信息不全");
        }

        // 获取参数
        String mobile = userInfoMap.get("mobile").toString();
        String idCard = userInfoMap.get("idCard").toString();
        String password = userInfoMap.get("password").toString();
        String confirmPassword = userInfoMap.get("confirmPassword").toString();
        int type = Integer.parseInt(userInfoMap.get("type").toString());

        int userCount = userDao.checkUserExist(mobile, type);
        if(userCount > 0) {
            throw new BusinessException("用户已存在");
        }

        if (password.isEmpty() || !password.equals(confirmPassword)) {
            throw new BusinessException("两次输入的密码不同");
        }

        // 设置user对象
        user.setUsername(mobile);
        user.setMobile(mobile);
        user.setId_card(idCard);
        user.setPassword(password);
        user.setType(type);

        userDao.save(user);

        return "保存成功";
    }

    // 登录方法
    public String login(Map<String, Object> userInfoMap) throws BusinessException {
        // 获取参数
        String mobile = userInfoMap.get("mobile").toString();
        String password = userInfoMap.get("password").toString();
        int type = Integer.parseInt(userInfoMap.get("type").toString());

        List<User> user = userDao.getUserByMobileAndPwd(mobile, password, type);

        if (user.isEmpty()) {
            String userType = "货主";

            if (type == 2) {
                userType = "司机";
            }
            throw new BusinessException(userType + "用户名或者密码错误");
        }

        return "登录成功";
    }

    // 修改密码
    public String changePassword(Map<String, Object> userInfoMap) throws BusinessException {
        // 获取参数
        String mobile = userInfoMap.get("mobile").toString();
        String oldPassword = userInfoMap.get("oldPassword").toString();
        String newPassword = userInfoMap.get("newPassword").toString();
        int type = Integer.parseInt(userInfoMap.get("type").toString());

        List<User> userList = userDao.getUserByMobileAndPwd(mobile, oldPassword, type);

        if (userList.isEmpty()) {
            throw new BusinessException("旧密码错误");
        }

        User user = userList.get(0);
        user.setPassword(newPassword);

        userDao.save(user);

        return "修改密码成功";
    }

}
