package com.springboot.goodsManage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Goods {
    @Id
    @GeneratedValue
    private Integer id;
    // 货名
    private String goods_name;
    // 货源状态 0:已发布 1:被接单 2:货主确认接单 3:进行中 4:已完成 5:货主已确认
    private int status;
    // 发布人
    private String publish_man;
    // 接单人
    private String order_taker;
    // 起始地文字
    private String start_place;
    // 起始地省份
    private String start_province;
    // 起始地城市
    private String start_city;
    // 起始地区县
    private String start_area;
    // 起始地详情
    private String start_place_detail;
    // 目的地文字
    private String end_place;
    // 目的地省份
    private String end_province;
    // 起始地城市
    private String end_city;
    // 起始地区县
    private String end_area;
    // 目的地详情
    private String end_place_detail;
    // 车长
    private String car_long;
    //车型
    private String car_type;
    //重货
    private int goods_weight;
    //泡货
    private int goods_volume;
    //报价方
    private String price_source;
    //装卸方式
    private String load_type;
    //装车时间
    private long load_time;
    //支付方式
    private String pay_type;
    //运费
    private int price;
    //备注
    private String comment;

    public String getStart_place() {
        return start_place;
    }

    public void setStart_place(String start_place) {
        this.start_place = start_place;
    }

    public String getEnd_place() {
        return end_place;
    }

    public void setEnd_place(String end_place) {
        this.end_place = end_place;
    }

    public int getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(int goods_weight) {
        this.goods_weight = goods_weight;
    }

    public int getGoods_volume() {
        return goods_volume;
    }

    public void setGoods_volume(int goods_volume) {
        this.goods_volume = goods_volume;
    }

    public String getStart_province() {
        return start_province;
    }

    public void setStart_province(String start_province) {
        this.start_province = start_province;
    }

    public String getStart_city() {
        return start_city;
    }

    public void setStart_city(String start_city) {
        this.start_city = start_city;
    }

    public String getStart_area() {
        return start_area;
    }

    public void setStart_area(String start_area) {
        this.start_area = start_area;
    }

    public String getEnd_province() {
        return end_province;
    }

    public void setEnd_province(String end_province) {
        this.end_province = end_province;
    }

    public String getEnd_city() {
        return end_city;
    }

    public void setEnd_city(String end_city) {
        this.end_city = end_city;
    }

    public String getEnd_area() {
        return end_area;
    }

    public void setEnd_area(String end_area) {
        this.end_area = end_area;
    }

    public String getPrice_source() {
        return price_source;
    }

    public void setPrice_source(String price_source) {
        this.price_source = price_source;
    }

    public String getLoad_type() {
        return load_type;
    }

    public void setLoad_type(String load_type) {
        this.load_type = load_type;
    }

    public long getLoad_time() {
        return load_time;
    }

    public void setLoad_time(long load_time) {
        this.load_time = load_time;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStart_place_detail() {
        return start_place_detail;
    }

    public void setStart_place_detail(String start_place_detail) {
        this.start_place_detail = start_place_detail;
    }

    public String getEnd_place_detail() {
        return end_place_detail;
    }

    public void setEnd_place_detail(String end_place_detail) {
        this.end_place_detail = end_place_detail;
    }

    public String getCar_long() {
        return car_long;
    }

    public void setCar_long(String car_long) {
        this.car_long = car_long;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

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
