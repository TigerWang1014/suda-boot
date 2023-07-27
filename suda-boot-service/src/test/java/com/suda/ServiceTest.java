package com.suda;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suda.repository.po.Order;
import com.suda.repository.po.UserIdInfo;
import com.suda.repository.po.UserInfo;
import com.suda.service.EsService;
import com.suda.service.OrderService;
import com.suda.service.UserIdInfoService;
import com.suda.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    private UserIdInfoService userIdInfoService;

    @Autowired
    private EsService esService;

    @Test
    void testUserInfoService() {
        UserInfo userInfo = UserInfo.builder()
                .userId(134)
                .userName("张三")
                .userAge(25)
                .createTime(LocalDateTime.now()).build();
        userInfoService.save(userInfo);
        userInfo = userInfoService.getById(userInfo);
    }

    @Test
    void testOrderService() {
        Order order = new Order();
        LocalDateTime dateTime = LocalDateTime.parse("2023-05-01 12:01:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        order.setCreateTime(dateTime);
        orderService.save(order);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_time", dateTime);
        orderService.getMap(queryWrapper);
    }

    @Test
    void testUserIdInfo() {
        UserIdInfo userIdInfo = new UserIdInfo();
        userIdInfo.setUserId(130);
        userIdInfo.setIdNum("230182198012251659");
        userIdInfo.setCreateTime(LocalDateTime.now());
        userIdInfoService.save(userIdInfo);
    }

    @Test
    void testEsService() throws IOException {
        esService.addIndex();
    }

    @Test
    void testEsServiceSearch() throws IOException {
       List<UserInfo> userInfos = esService.search("test");
       userInfos.forEach(userInfo -> {
           System.out.println(userInfo.getUserName());
       });
    }


}
