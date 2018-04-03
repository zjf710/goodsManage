package com.springboot.goodsManage.dao;

import com.springboot.goodsManage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.mobile = :mobile and u.password = :password and u.type = :type")
    User getUserByMobileAndPwd(@Param("mobile") String mobile, @Param("password") String password, @Param("type") int type);

    @Query("select COUNT(u) from User u where u.mobile = :mobile and u.type = :type")
    int checkUserExist(@Param("mobile") String mobile, @Param("type") int type);
}
