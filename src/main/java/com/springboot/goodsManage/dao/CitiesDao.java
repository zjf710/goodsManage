package com.springboot.goodsManage.dao;

import com.springboot.goodsManage.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitiesDao extends JpaRepository<Cities, Integer> {

    // 根据省份id查询城市信息
    List<Cities> findByProvinceId(String provinceId);
}
