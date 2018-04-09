package com.springboot.goodsManage.controller;

import com.springboot.goodsManage.dao.GoodsDao;
import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.Goods;
import com.springboot.goodsManage.model.result.Result;
import com.springboot.goodsManage.model.result.ResultUtil;
import com.springboot.goodsManage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;
    // 发布货源
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public Result publish(@RequestBody Map<String,Object> publishInfoMap) throws BusinessException {

        String msg = new GoodsService(goodsDao, new Goods()).publish(publishInfoMap);

        return ResultUtil.success(msg);
    }

    // 获取货物列表
    @RequestMapping(value = "/getGoods")
    public Result getGoods(@RequestParam Map<String,Object> searchParams) throws BusinessException {

        List<Map<String, Object>> goodsList = new GoodsService(goodsDao, new Goods()).getGoods(searchParams);

        return ResultUtil.success("查询成功", goodsList);
    }

    // 获取个人货物列表
    @RequestMapping(value = "/getUserGoods")
    public Result getUserGoods(@RequestParam Map<String,Object> searchParams) throws BusinessException {

        List<Map<String, Object>> goodsList = new GoodsService(goodsDao, new Goods()).getUserGoods(searchParams);

        return ResultUtil.success("查询成功", goodsList);
    }

    // 接单
    @RequestMapping(value = "/takeOrder", method = RequestMethod.POST)
    public Result takeOrder(@RequestBody Map<String,Object> goodsInfoMap) throws BusinessException {

        new GoodsService(goodsDao, new Goods()).goodsOrderStatusChange(goodsInfoMap);

        return ResultUtil.success("接单成功");
    }

    // 修改订单状态
    @RequestMapping(value = "/goodsOrderStatusChange", method = RequestMethod.POST)
    public Result goodsOrderStatusChange(@RequestBody Map<String,Object> goodsInfoMap) throws BusinessException {

        String msg = new GoodsService(goodsDao, new Goods()).goodsOrderStatusChange(goodsInfoMap);

        return ResultUtil.success(msg);
    }
}
