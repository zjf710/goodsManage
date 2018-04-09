package com.springboot.goodsManage.controller;

import com.springboot.goodsManage.dao.AreasDao;
import com.springboot.goodsManage.dao.CitiesDao;
import com.springboot.goodsManage.dao.ProvincesDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Areas;
import com.springboot.goodsManage.model.Cities;
import com.springboot.goodsManage.model.Provinces;
import com.springboot.goodsManage.model.result.Result;
import com.springboot.goodsManage.model.result.ResultUtil;
import com.springboot.goodsManage.service.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/area")
public class AreaController {

    @Autowired
    private ProvincesDao provincesDao;
    @Autowired
    private CitiesDao citiesDao;
    @Autowired
    private AreasDao areasDao;

    // 查询省份
    @RequestMapping(value = "/provinces")
    public Result provinces(@RequestParam Map<String,Object> searchParams) throws BusinessException {

        List<Provinces> provincesList = new AreasService(provincesDao, new Provinces()).provinces(searchParams);

        return ResultUtil.success("查询成功", provincesList);
    }

    // 查询城市
    @RequestMapping(value = "/cities")
    public Result cities(@RequestParam Map<String,Object> searchParams) throws BusinessException {

        List<Cities> citiesList = new AreasService(citiesDao, new Cities()).cities(searchParams);

        return ResultUtil.success("查询成功", citiesList);
    }

    // 查询区县
    @RequestMapping(value = "/areas")
    public Result areas(@RequestParam Map<String,Object> searchParams) throws BusinessException {

        List<Areas> areasList = new AreasService(areasDao, new Areas()).areas(searchParams);

        return ResultUtil.success("查询成功", areasList);
    }
}
