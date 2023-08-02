package com.suda.dto;

import com.suda.enums.BookType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangxinmin
 * @Date 2023/7/31 16:24
 */
@Data
@Getter
@Setter
public class BookDto {

    private BookType bookType;

    private String title;

}
