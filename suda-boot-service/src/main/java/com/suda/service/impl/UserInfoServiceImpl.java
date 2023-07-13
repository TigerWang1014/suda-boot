package com.suda.service.impl;

import com.suda.po.UserInfo;
import com.suda.mapper.UserInfoMapper;
import com.suda.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wangxinmin
 * @since 2023/06/30
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
