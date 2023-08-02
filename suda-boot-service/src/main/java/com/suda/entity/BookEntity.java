package com.suda.entity;

import com.suda.enums.BookType;
import com.suda.enums.BookTypeStrategyEnum;
import lombok.Data;
import lombok.Getter;

/**
 * @Author wangxinmin
 * @Date 2023/8/2 10:38
 */
@Data
public class BookEntity {

    private BookTypeStrategyEnum bookTypeStrategyEnum;

    private String title;
}
