package com.cun.util.es.config;


import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.Arrays;
import java.util.Objects;

@Configuration
@Data
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${spring.elasticsearch.uris}")
    private String ipAddress;

    private static final int ADDRESS_LENGTH = 2;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        HttpHost[] hosts = Arrays.stream(ipAddress.split(","))
                .map(this::makeHttpHost)
                .filter(Objects::nonNull)
                .toArray(HttpHost[]::new);
        RestClientBuilder restClientBuilder = RestClient.builder(hosts);
        return new RestHighLevelClient(restClientBuilder);
    }

    /**
     * 根据配置创建HttpHost
     *
     * @param s
     * @return
     */
    private HttpHost makeHttpHost(String s) {
        String[] address = s.split(":");
        if (address.length == ADDRESS_LENGTH) {
            String ip = address[0];
            int port = Integer.parseInt(address[1]);
            return new HttpHost(ip, port);
        } else {
            return null;
        }
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }

}