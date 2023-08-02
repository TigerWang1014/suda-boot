package com.suda.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author wangxinmin
 * @Date 2023/7/31 16:25
 */
@Getter
@AllArgsConstructor
public enum BookType {

    science("science", "科幻"),
    magic("magic", "魔幻");

    private final String code;

    private final String name;


}
