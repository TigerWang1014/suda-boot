package com.suda.enums;

import com.suda.service.impl.BookMagicServiceImpl;
import com.suda.service.impl.BookScienceServiceImpl;
import com.suda.strategy.SearchStrategy;
import com.suda.utils.SpringBeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author wangxinmin
 * @Date 2023/8/2 10:40
 */
@Getter
@AllArgsConstructor
public enum BookTypeStrategyEnum {

    science("science", "科幻", SpringBeanUtil.getBean(BookScienceServiceImpl.class)),
    magic("magic", "魔幻", SpringBeanUtil.getBean(BookMagicServiceImpl.class));

    private final String code;

    private final String name;

    private final SearchStrategy strategy;
}
