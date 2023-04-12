package com.javaclimb.houserent.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.javaclimb.houserent.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 房子信息
 */
@Data
@TableName("t_house")
public class House extends BaseEntity {

    /**
     * 房东用户id
     */
    private Long userId;

    /**
     * 出租类型：整租whole/合租share
     */
    private String rentType;

    /**
     * 房屋名称
     */
    private String title;

    /**
     * 详细描述内容
     */
    private String content;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 详细地址，具体门牌号
     */
    private String address;

    /**
     * 缩略图URL
     */
    private String thumbnailUrl;

    /**
     * 轮播图URL
     */
    private String slideUrl;

    /**
     * 月租金额
     */
    private Integer monthRent;

    /**
     * 状态：0未租出 1已租出 -1已下架 -2待审核 -3审核不通过
     */
    private Integer status;

    /**
     * 房产证号
     */
    private String cetificateNo;

    /**
     * 卫生间数量
     */
    private String toiletNum;

    /**
     * 厨房数量
     */
    private String kichenNum;

    /**
     * 客厅数量
     */
    private String livingRoomNum;

    /**
     * 卧室数量
     */
    private String bedroomNum;

    /**
     * 是否有空调 1 有 0 无
     */
    private String hasAirConditioner;

    /**
     * 面积
     */
    private double area;

    /**
     * 当前所在楼层数
     */
    private Integer floor;

    /**
     * 房子最大楼层数
     */
    private Integer maxFloor;

    /**
     * 是否有电梯 1是 0否
     */
    private Integer hasElevator;

    /**
     * 建成年份
     */
    private Integer buildYear;

    /**
     * 房屋朝向
     */
    private String direction;

    /**
     * 上次开始入住时间
     */
    private Date lastOrderStartTime;

    /**
     * 上次结束入住时间
     */
    private Date lastOrderEndTime;

    /**
     * 经纬度
     */
    private String longitudeLatitude;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人电话
     */
    private String contactPhone;

}
