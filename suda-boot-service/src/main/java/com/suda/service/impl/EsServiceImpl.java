package com.suda.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import com.suda.repository.po.UserInfo;
import com.suda.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangxinmin
 * @Date 2023/7/18 14:37
 */
@Service
public class EsServiceImpl implements EsService {

    @Autowired
    private ElasticsearchClient esClient;

    @Override
    public void addIndex() throws IOException {
        UserInfo userInfo = UserInfo.builder().userAge(23).userName("张三").build();
        UserInfo userInfo1 = UserInfo.builder().userAge(24).userName("李四").build();
        esClient.index(i -> i.index("test").id("123").document(userInfo));
        esClient.index(i -> i.index("test").id("456").document(userInfo1));

    }

    @Override
    public List<UserInfo> search(String key) throws IOException {
        List<UserInfo> userInfoList = new ArrayList<>();
        SearchResponse<UserInfo> searchResponse = esClient.search(s -> {
            return s.index(key);
        }, UserInfo.class);
        TotalHits total = searchResponse.hits().total();
        List<Hit<UserInfo>> hits = searchResponse.hits().hits();
        hits.forEach(e -> {
            userInfoList.add(e.source());
        });
        return userInfoList;
    }

}
