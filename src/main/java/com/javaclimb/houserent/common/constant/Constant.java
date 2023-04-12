package com.javaclimb.houserent.common.constant;

/**
 * 常量类
 */
public class Constant {

    /*用户SESSION的key*/
    public static final String SESSION_USER_KEY ="user";

    /*相对路径*/
    public static final String UPLOADS_ABSOLUTE_PATH = "/uploads/";

    /*上传目录*/
    //getProperty("user.home") 当前系统根目录
    public static final String UPLOADS_PATH = System.getProperties().getProperty("user.home")+UPLOADS_ABSOLUTE_PATH;

    /*图片session前缀*/
    public static final String SESSION_IMG_PREFIX = "SESSION_IMG";
}
