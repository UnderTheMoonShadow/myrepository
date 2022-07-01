package com.x.entity;

import java.util.Date;


public class Item {
    private Integer id;
    private String title;// 标题，字符串
    // private String img;//商品图片，字符串，推导属性，是可以通过当前类型中其他属性推导技术得出结果的。
    // private String link;//跳转链接，字符串，推导属性。
    private Long sales;//销量，数学
    private Integer recommendation;//是否为热门，布尔
    private Integer recoSort;//热门排序|权重，数学
    private String city;//所属城市，字符串
    private String price;// 价格，数学, 单位是元
    private String rentType;//租赁方式，整租，合租等。 字符串
    private String houseType;// 房屋面积，字符串
    private String info;// 房屋特性， Map集合。集合存储数据内容为： years: "建造年份", type: "房屋类型，几室几厅", level: "所在楼层", style: "装修标准", orientation: "房屋朝向"
    private String imgs;// 图片集合。字符串数组或集合
    private Date buytime; // 可购买时间， 可预订时间。
    private Integer isRented; // 是否已出租
    private String img;//详情图片

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Integer getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Integer recommendation) {
        this.recommendation = recommendation;
    }

    public Integer getRecoSort() {
        return recoSort;
    }

    public void setRecoSort(Integer recoSort) {
        this.recoSort = recoSort;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Integer getIsRented() {
        return isRented;
    }

    public void setIsRented(Integer isRented) {
        this.isRented = isRented;
    }
}
