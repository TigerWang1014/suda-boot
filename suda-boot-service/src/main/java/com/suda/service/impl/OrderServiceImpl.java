package com.suda.service.impl;

import com.suda.repository.po.Order;
import com.suda.repository.mapper.OrderMapper;
import com.suda.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wangxinmin
 * @since 2023/07/04
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
