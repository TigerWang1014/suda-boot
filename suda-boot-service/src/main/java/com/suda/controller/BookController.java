package com.suda.controller;

import com.suda.api.BookApi;
import com.suda.dto.BookDto;
import com.suda.entity.BookEntity;
import com.suda.enums.BookTypeStrategyEnum;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangxinmin
 * @Date 2023/8/2 11:02
 */
@RestController
public class BookController implements BookApi {
    @Override
    public String type(BookDto bookDto) {
        BookEntity entity = toEntity(bookDto);
        return entity.getBookTypeStrategyEnum().getStrategy().srarch(entity);
    }

    private BookEntity toEntity(BookDto bookDto) {
        BookEntity entity = new BookEntity();
        entity.setTitle(bookDto.getTitle());
        entity.setBookTypeStrategyEnum(BookTypeStrategyEnum.valueOf(bookDto.getBookType().name()));
        return entity;
    }
}
