package com.suda.service.impl;

import com.suda.repository.po.UserIdInfo;
import com.suda.repository.mapper.UserIdInfoMapper;
import com.suda.service.UserIdInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户身份信息表 服务实现类
 * </p>
 *
 * @author wangxinmin
 * @since 2023/07/10
 */
@Service
public class UserIdInfoServiceImpl extends ServiceImpl<UserIdInfoMapper, UserIdInfo> implements UserIdInfoService {

}
