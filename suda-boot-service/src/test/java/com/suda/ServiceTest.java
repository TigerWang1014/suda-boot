package com.suda;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suda.repository.po.Order;
import com.suda.repository.po.UserIdInfo;
import com.suda.repository.po.UserInfo;
import com.suda.service.OrderService;
import com.suda.service.UserIdInfoService;
import com.suda.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author wangxinmin
 * @Date 2023/6/16 16:48
 */
public class ServiceTest extends ApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserIdInfoService userIdInfoService ;

    @Test
    void testUserInfoService() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(134);
        userInfo.setUserName("张三");
        userInfo.setUserAge(25);
        userInfo.setCreateTime(LocalDateTime.now());
        userInfoService.save(userInfo);
        userInfo = userInfoService.getById(userInfo);
    }

    @Test
    void testOrderService(){
        Order order = new Order();
        LocalDateTime dateTime = LocalDateTime.parse("2023-05-01 12:01:01",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        order.setCreateTime(dateTime);
        orderService.save(order);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_time",dateTime);
        orderService.getMap(queryWrapper);
    }

    @Test
    void testUserIdInfo(){
        UserIdInfo userIdInfo = new UserIdInfo();
        userIdInfo.setUserId(130);
        userIdInfo.setIdNum("230182198012251659");
        userIdInfo.setCreateTime(LocalDateTime.now());
        userIdInfoService.save(userIdInfo);
    }



}
