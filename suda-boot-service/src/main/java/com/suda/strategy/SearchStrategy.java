package com.suda.strategy;

import com.suda.dto.BookDto;
import com.suda.entity.BookEntity;

/**
 * @Author wangxinmin
 * @Date 2023/8/2 09:08
 */
public interface SearchStrategy {

    String srarch(BookEntity bookEntity);
}
