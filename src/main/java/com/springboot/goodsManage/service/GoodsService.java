package com.springboot.goodsManage.service;

import com.springboot.goodsManage.dao.GoodsDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Goods;

import java.util.List;
import java.util.Map;

public class GoodsService {

    private GoodsDao goodsDao;
    private Goods goods;

    public GoodsService(GoodsDao goodsDao, Goods goods) {
        this.goodsDao = goodsDao;
        this.goods = goods;
    }

    // 发布货源
    public String publish(Map<String, Object> publishInfoMap) throws BusinessException {

        // 获取参数
        String goodsName = publishInfoMap.get("goodsName").toString();
        String publishMan = publishInfoMap.get("publishMan").toString();
        String startPlace = publishInfoMap.get("startPlace").toString();
        String startProvince = publishInfoMap.get("startProvince").toString();
        String startCity = publishInfoMap.get("startCity").toString();
        String startArea = publishInfoMap.get("startArea").toString();
        String startPlaceDetail = publishInfoMap.get("startPlaceDetail").toString();
        String endPlace = publishInfoMap.get("endPlace").toString();
        String endProvince = publishInfoMap.get("endProvince").toString();
        String endCity = publishInfoMap.get("endCity").toString();
        String endArea = publishInfoMap.get("endArea").toString();
        String endPlaceDetail = publishInfoMap.get("endPlaceDetail").toString();
        String carLong = publishInfoMap.get("carLong").toString();
        String carType = publishInfoMap.get("carType").toString();
        String goodsWeight = publishInfoMap.get("goodsWeight").toString();
        String goodsVolume = publishInfoMap.get("goodsVolume").toString();
        String priceSource = publishInfoMap.get("priceSource").toString();
        String loadType = publishInfoMap.get("loadType").toString();
        String loadTime = publishInfoMap.get("loadTime").toString();
        String payType = publishInfoMap.get("payType").toString();
        String price = publishInfoMap.get("price").toString();
        String comment = publishInfoMap.get("comment").toString();

        // 设置货源对象
        goods.setGoods_name(goodsName);
        goods.setPublish_man(publishMan);
        goods.setStart_place(startPlace);
        goods.setStart_province(startProvince);
        goods.setStart_city(startCity);
        goods.setStart_area(startArea);
        goods.setStart_place_detail(startPlaceDetail);
        goods.setEnd_place(endPlace);
        goods.setEnd_province(endProvince);
        goods.setEnd_city(endCity);
        goods.setEnd_area(endArea);
        goods.setEnd_place_detail(endPlaceDetail);
        goods.setCar_long(carLong);
        goods.setCar_type(carType);

        if(!"".equals(goodsWeight)) {
            goods.setGoods_weight(Integer.parseInt(goodsWeight));
        } else {
            goods.setGoods_volume(Integer.parseInt(goodsVolume));
        }
        goods.setPrice_source(priceSource);
        goods.setLoad_type(loadType);

        if(!"".equals(loadTime)) {
            goods.setLoad_time(Long.parseLong(loadTime));
        }
        goods.setPay_type(payType);
        if(!"".equals(price)) {
            goods.setPrice(Integer.parseInt(price));
        }
        goods.setComment(comment);

        goodsDao.save(goods);

        return "保存成功";
    }

    // 获取订单详情
    public List<Map<String, Object>> getGoods(Map<String,Object> searchParams) throws BusinessException {

        String status = searchParams.get("status").toString();
        return goodsDao.findGoodsInfoByStatus(Integer.parseInt(status));
    }

    // 获取订单详情
    public List<Map<String, Object>> getUserGoods(Map<String,Object> searchParams) throws BusinessException {

        String user = searchParams.get("user").toString();
        String type = searchParams.get("userType").toString();

        // 货主
        if("1".equals(type)) {
            return goodsDao.findGoodsInfoByPublishMan(user);
        } else if("2".equals(type)) {
            return goodsDao.findGoodsInfoByOrderTaker(user);
        }

        throw new BusinessException("用户类型错误");
    }

    // 修改订单状态
    public String goodsOrderStatusChange(Map<String, Object> takeGoods) throws BusinessException {

        // 获取参数
        int goodsId = Integer.parseInt(takeGoods.get("id").toString());
        int status = Integer.parseInt(takeGoods.get("status").toString());

        Goods goods = goodsDao.findById(goodsId);

        if(goods == null) {
            throw new BusinessException("货源不存在");
        }

        // 修改货源状态
        goods.setStatus(status);

        goodsDao.save(goods);

        return "修改状态成功";
    }
}
