package com.springboot.goodsManage.service;

import com.springboot.goodsManage.dao.AreasDao;
import com.springboot.goodsManage.dao.CitiesDao;
import com.springboot.goodsManage.dao.GoodsDao;
import com.springboot.goodsManage.dao.ProvincesDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Areas;
import com.springboot.goodsManage.model.Cities;
import com.springboot.goodsManage.model.Goods;
import com.springboot.goodsManage.model.Provinces;

import java.util.List;
import java.util.Map;

public class AreasService {

    private ProvincesDao provincesDao;
    private Provinces provinces;
    private CitiesDao citiesDao;
    private Cities cities;
    private AreasDao areasDao;
    private Areas areas;

    public AreasService(ProvincesDao provincesDao, Provinces provinces) {
        this.provincesDao = provincesDao;
        this.provinces = provinces;
    }

    public AreasService(CitiesDao citiesDao, Cities cities) {
        this.citiesDao = citiesDao;
        this.cities = cities;
    }

    public AreasService(AreasDao areasDao, Areas areas) {
        this.areasDao = areasDao;
        this.areas = areas;
    }

    // 查询省份
    public List<Provinces> provinces(Map<String, Object> searchParams) throws BusinessException {

        if(searchParams.containsKey("provinceId")) {
            String provinceId = searchParams.get("provinceId").toString();
            return provincesDao.findByProvinceId(provinceId);
        }

        return provincesDao.findAll();
    }

    // 查询城市
    public List<Cities> cities(Map<String, Object> searchParams) throws BusinessException {

        if(searchParams.containsKey("provinceId")) {
            String provinceId = searchParams.get("provinceId").toString();
            return citiesDao.findByProvinceId(provinceId);
        }

        return citiesDao.findAll();
    }

    // 查询区县
    public List<Areas> areas(Map<String, Object> searchParams) throws BusinessException {

        if(searchParams.containsKey("cityId")) {
            String cityId = searchParams.get("cityId").toString();
            return areasDao.findByCityId(cityId);
        }

        return areasDao.findAll();
    }
}
