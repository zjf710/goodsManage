package com.springboot.goodsManage.controller;

import com.springboot.goodsManage.dao.CarDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Car;
import com.springboot.goodsManage.model.result.Result;
import com.springboot.goodsManage.model.result.ResultUtil;
import com.springboot.goodsManage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarDao carDao;

    // 查询车属性
    @RequestMapping(value = "/getProperties")
    public Result getCarProperties(@RequestParam(required = false, value = "types") List<String> types) throws BusinessException {

        List<Car> provincesList = new CarService(carDao, new Car()).getCarProperties(types);

        return ResultUtil.success("查询成功", provincesList);
    }
}
