package com.springboot.goodsManage.dao;

import com.springboot.goodsManage.model.Areas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreasDao extends JpaRepository<Areas, Integer> {

    // 根据城市id查询区县信息
    List<Areas> findByCityId(String cityId);
}
