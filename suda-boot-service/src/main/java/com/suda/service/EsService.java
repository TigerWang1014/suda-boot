package com.suda.service;

import com.suda.repository.po.UserInfo;

import java.io.IOException;
import java.util.List;

/**
 * @Author wangxinmin
 * @Date 2023/7/18 14:37
 */
public interface EsService{

    void addIndex() throws IOException;

    List<UserInfo> search(String key) throws IOException;

}
