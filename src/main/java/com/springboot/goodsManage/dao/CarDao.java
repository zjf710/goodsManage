package com.springboot.goodsManage.dao;

import com.springboot.goodsManage.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarDao extends JpaRepository<Car, Integer> {

    // 根据类型查询值
    List<Car> findByType(String type);
    // 根据多个类型查询值
    @Query("select c from Car c where c.type in (:types)")
    List<Car> findByTypes(@Param("types") List<String> types);
}
