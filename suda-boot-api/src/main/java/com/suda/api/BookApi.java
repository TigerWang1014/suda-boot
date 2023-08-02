package com.suda.api;

import com.suda.dto.BookDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangxinmin
 * @Date 2023/7/31 16:20
 */
@RequestMapping("/book")
public interface BookApi {
    @PostMapping("/type")
    String type(@RequestBody BookDto bookDto);
}
