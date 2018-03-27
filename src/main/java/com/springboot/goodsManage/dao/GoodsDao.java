package com.springboot.goodsManage.dao;

import com.springboot.goodsManage.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDao extends JpaRepository<Goods, Integer> {

    // 根据id查询货物信息
    Goods findById(int id);
}
