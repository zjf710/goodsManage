package com.springboot.goodsManage.service;

import com.springboot.goodsManage.dao.CarDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Car;

import java.util.List;
import java.util.Map;

public class CarService {

    private CarDao carDao;
    private Car car;

    public CarService(CarDao carDao, Car car) {
        this.carDao = carDao;
        this.car = car;
    }

    // 查询车属性
    public List<Car> getCarProperties(List<String> types) throws BusinessException {

        if(types.size() > 0) {
            return carDao.findByTypes((List<String>)types);
        }

        return carDao.findAll();
    }
}
