package com.springboot.goodsManage.dao;

import com.springboot.goodsManage.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface GoodsDao extends JpaRepository<Goods, Integer> {

    // 根据id查询货物信息
    Goods findById(int id);

    // 根据status查询货物信息
    @Query(value = "select u.username, g.* from Goods g, User u where g.status = :status and u.mobile = g.publish_man and u.type = 1", nativeQuery = true)
    List<Map<String, Object>> findGoodsInfoByStatus(@Param("status") int status);

    // 根据发布者查询货物信息
    @Query(value = "select u1.username, u2.username as order_taker_name, g.* from Goods g, User u1, User u2 where g.publish_man = :publish_man and u1.mobile = g.publish_man and u1.type = 1 and u2.mobile = g.order_taker and u2.type = 2", nativeQuery = true)
    List<Map<String, Object>> findGoodsInfoByPublishMan(@Param("publish_man") String publish_man);

    // 根据接单者查询货物信息
    @Query(value = "select u1.username, u2.username as order_taker_name, g.* from Goods g, User u1, User u2 where g.order_taker = :order_taker and u1.mobile = g.publish_man and u1.type = 1 and u2.mobile = g.order_taker and  u2.type = 2", nativeQuery = true)
    List<Map<String, Object>> findGoodsInfoByOrderTaker(@Param("order_taker") String order_taker);
}
