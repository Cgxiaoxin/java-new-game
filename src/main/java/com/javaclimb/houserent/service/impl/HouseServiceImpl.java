package com.javaclimb.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.houserent.entity.House;
import com.javaclimb.houserent.mapper.HouseMapper;
import com.javaclimb.houserent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 房子服务接口实现
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;
    /**
     * mapper对象
     * @return
     */
    @Override
    public BaseMapper<House> getRepository() {
        return houseMapper;
    }

    /**
     * 获得查询器
     * @param house
     * @return
     */
    @Override
    public QueryWrapper<House> getQueryWrapper(House house) {
        QueryWrapper<House> queryWrapper = new QueryWrapper<>();
        if (house!=null&&house.getUserId()!=null){
            queryWrapper.eq("user_id",house.getUserId());
        }
        return queryWrapper;
    }

    /**
     * 获得带参数的查询器
     * @param condition
     * @return
     */
    @Override
    public QueryWrapper<House> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }


}
