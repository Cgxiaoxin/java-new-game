package com.javaclimb.houserent.controller.backend;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaclimb.houserent.common.base.BaseController;
import com.javaclimb.houserent.common.constant.Constant;
import com.javaclimb.houserent.common.dto.JsonResult;
import com.javaclimb.houserent.common.enums.HouseStatusEnum;
import com.javaclimb.houserent.common.util.PageUtil;
import com.javaclimb.houserent.entity.House;
import com.javaclimb.houserent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 房子控制器
 */
@Controller
@RequestMapping("/admin/house")
public class HouseController extends BaseController {

    @Autowired
    private HouseService houseService;

    /**
     * 进入房子页面管理页面
     */
    @RequestMapping("")
    public String houseList(@RequestParam(value = "page",defaultValue = "1")Long pageNumber, @RequestParam(value = "size",defaultValue = "6")Long pageSize, Model model){
        Page page = PageUtil.initMpPage(pageNumber,pageSize);
        House condition = new House();
        //如果登录用户是管理员，可以查询所有房子，如果登录用户不是管理员，只能查询自己的房子
        if (!loginUserIsAdmin()){
            condition.setUserId(getLoginUserId());
        }
        Page<House> housePage = houseService.findAll(page,condition);
        model.addAttribute("pageInfo",housePage);
        model.addAttribute("pagePrefix","/admin/house?");
        model.addAttribute("isAdmin",loginUserIsAdmin());
        return "admin/house-list";
    }

    /**
     * 进入房子发布页面
     */
    @RequestMapping("/publish")
    public String publish(){
        return "admin/house-publish";
    }

    /**
     * 发布房子提交
     * @return
     */
    @RequestMapping("/publish/submit")
    @ResponseBody
    public JsonResult publishSubmit(House house, @RequestParam("key") String key, HttpSession session){  //(House house)  获取前端传进的房子对象
        try {
            house.setCreateTime(new Date());
            house.setUserId(getLoginUserId());
            house.setStatus(HouseStatusEnum.NOT_CHECK.getValue());
            //获取轮播图
            String sessionKey = Constant.SESSION_IMG_PREFIX + key;
            List<String> imgList = (List<String>) session.getAttribute(sessionKey);
            if (imgList!=null && imgList.size()>0){
                //把轮播图转换成json格式存储
                house.setSlideUrl(JSON.toJSONString(imgList));
                //把轮播图的第一个图放到缩略图
                house.setThumbnailUrl(imgList.get(0));
            }
            houseService.insertOrUpdate(house);
        }catch (Exception e){
            return JsonResult.error("发布失败，请填写完整信息");
        }
        return JsonResult.success("发布成功",house.getId());
    }
}
