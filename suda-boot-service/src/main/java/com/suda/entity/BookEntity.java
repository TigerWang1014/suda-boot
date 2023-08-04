package com.suda.entity;

import com.suda.enums.BookTypeStrategyEnum;
import lombok.Data;

/**
 * @Author wangxinmin
 * @Date 2023/8/2 10:38
 */
@Data
public class BookEntity {

    private BookTypeStrategyEnum bookTypeStrategyEnum;

    private String title;
}
