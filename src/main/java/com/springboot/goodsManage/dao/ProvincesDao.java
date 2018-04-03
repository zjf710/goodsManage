package com.springboot.goodsManage.dao;

import com.springboot.goodsManage.model.Provinces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvincesDao extends JpaRepository<Provinces, Integer> {

    // 根据省份id查询省份信息
    List<Provinces> findByProvinceId(String provinceId);
}
