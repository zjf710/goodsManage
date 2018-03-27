package com.springboot.goodsManage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Goods {
    @Id
    @GeneratedValue
    private Integer id;
    // 货名
    private String goods_name;
    // 货源状态 0:已发布 1:被接单 2:进行中 3:已完成 4:货主已确认
    private int status;
    // 发布人
    private String publish_man;
    // 接单人
    private String order_taker;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getPublish_man() {
        return publish_man;
    }

    public void setPublish_man(String publish_man) {
        this.publish_man = publish_man;
    }

    public String getOrder_taker() {
        return order_taker;
    }

    public void setOrder_taker(String order_taker) {
        this.order_taker = order_taker;
    }
}
