package com.springboot.goodsManage.controller;

import com.springboot.goodsManage.dao.GoodsDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Goods;
import com.springboot.goodsManage.model.result.Result;
import com.springboot.goodsManage.model.result.ResultUtil;
import com.springboot.goodsManage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;
    // 发布货源
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public Result publish(@RequestParam Map<String,Object> publishInfoMap) throws BusinessException {

        String msg = new GoodsService(goodsDao, new Goods()).publish(publishInfoMap);

        return ResultUtil.success(msg);
    }

    // 修改订单状态
    @RequestMapping(value = "/goodsOrderStatusChange", method = RequestMethod.POST)
    public Result goodsOrderStatusChange(@RequestParam Map<String,Object> goodsInfoMap) throws BusinessException {

        String msg = new GoodsService(goodsDao, new Goods()).goodsOrderStatusChange(goodsInfoMap);

        return ResultUtil.success(msg);
    }
}
