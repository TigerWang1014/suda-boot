package com.suda.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @Author wangxinmin
 * @Date 2023/7/18 16:23
 */
public class ElasticsearchConfig {
    @Value("${spring.elasticsearch.uris}")
    private String elasticsearchUris;
    @Bean
    public ElasticsearchClient elasticsearchClient() {
        return new ElasticsearchClient(null);
    }
}
