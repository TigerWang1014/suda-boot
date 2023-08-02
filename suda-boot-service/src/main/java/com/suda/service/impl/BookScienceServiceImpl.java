package com.suda.service.impl;

import com.suda.entity.BookEntity;
import com.suda.strategy.SearchStrategy;
import org.springframework.stereotype.Service;

/**
 * @Author wangxinmin
 * @Date 2023/8/2 11:19
 */
@Service
public class BookScienceServiceImpl implements SearchStrategy {
    @Override
    public String srarch(BookEntity entity) {
        return entity.getBookTypeStrategyEnum().getName();
    }
}
