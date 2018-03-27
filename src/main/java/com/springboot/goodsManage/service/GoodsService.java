package com.springboot.goodsManage.service;

import com.springboot.goodsManage.dao.GoodsDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Goods;

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
        String goods_name = publishInfoMap.get("goods_name").toString();
        String publish_man = publishInfoMap.get("publish_man").toString();

        // 设置货源对象
        goods.setGoods_name(goods_name);
        goods.setPublish_man(publish_man);

        goodsDao.save(goods);

        return "保存成功";
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

        return "保存成功";
    }
}
