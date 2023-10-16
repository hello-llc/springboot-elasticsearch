package com.cun.util.es.service;


import com.cun.util.es.db.mapper.MetaDatasourceMapper;
import com.cun.util.es.db.mapper.MetaTableMapper;
import com.cun.util.es.db.pojo.MetaDatasource;
import com.cun.util.es.db.pojo.MetaDatasourceExample;
import com.cun.util.es.db.pojo.MetaTable;
import com.cun.util.es.db.pojo.MetaTableExample;
import com.cun.util.es.module.*;
import com.cun.util.es.repository.HintSearchRepository;
import com.cun.util.es.utils.LoggerUtilFactory;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EsService {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private HintSearchRepository hintSearchRepository;
    @Autowired
    MetaTableMapper metaTableMapper;
    @Autowired
    MetaDatasourceMapper metaDatasourceMapper;


    private static Logger log = LoggerUtilFactory.getLoggerUtil();

    public BaseResponse delEsIndex(DelEsIndexParam delEsIndexParam) {
        BaseResponse baseResponse = new BaseResponse();
        if (StringUtils.isNotBlank(delEsIndexParam.getIndexName())) {
            if (elasticsearchRestTemplate.indexOps(IndexCoordinates.of(delEsIndexParam.getIndexName())).exists()) {
                elasticsearchRestTemplate.indexOps(IndexCoordinates.of(delEsIndexParam.getIndexName())).delete();
                return baseResponse.success(delEsIndexParam.getIndexName() + "，索引删除成功");
            } else {
                return baseResponse.error(delEsIndexParam.getIndexName() + "，索引不存在");
            }
        } else {
            return baseResponse.error("未配置索引名称");
        }
    }

    public BaseResponse batchInsertEsIndex() {
        BaseResponse baseResponse = new BaseResponse();
        MetaTableExample nameExample = new MetaTableExample();
        MetaTableExample.Criteria nameCriteria = nameExample.createCriteria();
        nameCriteria.andDelFlagEqualTo(false);
        List<MetaTable> metaTableList = metaTableMapper.selectByExample(nameExample);
        List<HintSearchEsParam> hintSearchEsParamList = new ArrayList<>();
        for (MetaTable metaTable : metaTableList) {
            MetaDatasourceExample metaDatasourceExample = new MetaDatasourceExample();
            MetaDatasourceExample.Criteria criteria = metaDatasourceExample.createCriteria();
            criteria.andDelFlagEqualTo(false);
            criteria.andTableIdEqualTo(metaTable.getId());
            List<MetaDatasource> metaDatasourceList = metaDatasourceMapper.selectByExample(metaDatasourceExample);
            for (MetaDatasource metaDatasource : metaDatasourceList) {
                HintSearchEsParam hintSearchEsParam = new HintSearchEsParam();
                hintSearchEsParam.setId(metaDatasource.getId());
                hintSearchEsParam.setName(metaTable.getTableZhName());
                hintSearchEsParam.setTable_name(metaTable.getTableName());
                hintSearchEsParam.setSource_table(metaDatasource.getSourceTableName());
                hintSearchEsParam.setTable_id(metaDatasource.getTableId());
                hintSearchEsParamList.add(hintSearchEsParam);
            }
        }

        hintSearchRepository.saveAll(hintSearchEsParamList);

        return baseResponse.success("数据写入ES成功");
    }

    public BaseResponse insertEsIndex() {
        BaseResponse baseResponse = new BaseResponse();
        HintSearchEsParam hintSearchEsParam = new HintSearchEsParam();
        hintSearchEsParam.setId(10000L);
        hintSearchEsParam.setName("demo");
        hintSearchEsParam.setTable_name("demo");
        hintSearchEsParam.setSource_table("demo");
        hintSearchEsParam.setTable_id(10000L);

        hintSearchRepository.save(hintSearchEsParam);

        return baseResponse.success("数据写入ES成功");
    }

    public BaseResponse queryEsIndex(QueryHintParam queryHintParam) {
        BaseResponse baseResponse = new BaseResponse();
        List<HintSearchResponse> result = new ArrayList<>();
        if (elasticsearchRestTemplate.indexOps(IndexCoordinates.of("data_platform_hint")).exists()) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                    .should(QueryBuilders.matchQuery("name", queryHintParam.getQueryString()).fuzziness("1"))
                    .should(QueryBuilders.wildcardQuery("name", "*" + queryHintParam.getQueryString().toLowerCase(Locale.ROOT) + "*"))
                    .should(QueryBuilders.wildcardQuery("table_name", "*" + queryHintParam.getQueryString().toLowerCase(Locale.ROOT) + "*"))
                    .should(QueryBuilders.wildcardQuery("source_table", "*" + queryHintParam.getQueryString().toLowerCase(Locale.ROOT) + "*"));
            NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(boolQueryBuilder);
            SearchHits<HintSearchEsParam> search = elasticsearchRestTemplate.search(nativeSearchQuery, HintSearchEsParam.class);

            // 获取查询的结果
            Set<Long> tableIdSet = new HashSet<>();
            search.getSearchHits().forEach(
                    n -> {
                        HintSearchEsParam content = n.getContent();
                        if (StringUtils.isNotBlank(content.getName()) && content.getName().contains(queryHintParam.getQueryString().toLowerCase(Locale.ROOT)) && !tableIdSet.contains(content.getTable_id())) {
                            HintSearchResponse hintSearchResponse = new HintSearchResponse();
                            hintSearchResponse.setSearchName(content.getName());
                            hintSearchResponse.setTableId(content.getTable_id());
                            hintSearchResponse.setShowName(content.getName());
                            result.add(hintSearchResponse);
                            tableIdSet.add(content.getTable_id());
                        }
                        if (StringUtils.isNotBlank(content.getTable_name()) && content.getTable_name().contains(queryHintParam.getQueryString().toLowerCase(Locale.ROOT)) && !tableIdSet.contains(content.getTable_id())) {
                            HintSearchResponse hintSearchResponse = new HintSearchResponse();
                            hintSearchResponse.setSearchName(content.getTable_name());
                            hintSearchResponse.setTableId(content.getTable_id());
                            hintSearchResponse.setShowName(content.getName());
                            result.add(hintSearchResponse);
                            tableIdSet.add(content.getTable_id());
                        }
                        if (StringUtils.isNotBlank(content.getSource_table()) && content.getSource_table().contains(queryHintParam.getQueryString().toLowerCase(Locale.ROOT)) && !tableIdSet.contains(content.getTable_id())) {
                            HintSearchResponse hintSearchResponse = new HintSearchResponse();
                            hintSearchResponse.setSearchName(content.getSource_table());
                            hintSearchResponse.setTableId(content.getTable_id());
                            hintSearchResponse.setShowName(content.getName());
                            result.add(hintSearchResponse);
                            tableIdSet.add(content.getTable_id());
                        }
                    }
            );
        }

        return baseResponse.success(result);
    }

    public void queryEsById(QueryHintParam queryHintParam) {
        Optional<HintSearchEsParam> hintSearchEsParam = hintSearchRepository.findById(queryHintParam.getId());
        if (hintSearchEsParam.isPresent()) {
            HintSearchEsParam searchEsParam = hintSearchEsParam.get();
            log.info("查询ES信息:{}", searchEsParam);
        } else {
            log.info("没有此ES");
        }
    }

    public void updateEsById(QueryHintParam queryHintParam) {
        // 更新文档
        Optional<HintSearchEsParam> hintSearchEsParam = hintSearchRepository.findById(queryHintParam.getId());
        if (!hintSearchEsParam.isPresent()) {
            return;
        }
        HintSearchEsParam esParam = hintSearchEsParam.get();
        esParam.setTable_name("updateDemo");
        esParam.setSource_table("updateDemo");

        //进行更新
        hintSearchRepository.save(esParam);

        log.info("更新ES成功");
    }

    public void batchUpdateEs() {
        Iterable<HintSearchEsParam> allList = hintSearchRepository.findAllById(Arrays.asList(10000, 773, 777));
        allList.forEach(
                n -> {
                    n.setSource_table(UUID.randomUUID().toString());
                }
        );

        List<HintSearchEsParam> findAllList = Lists.newArrayList(allList);

        //批量处理
        hintSearchRepository.saveAll(findAllList);

        log.info("批量修改ES成功");
    }

    public void deleteEsById(QueryHintParam queryHintParam) {
        hintSearchRepository.deleteById(queryHintParam.getId());
        log.info("删除ES成功");
    }

    public void batchDeleteEs() {
        Iterable<HintSearchEsParam> allList = hintSearchRepository.findAllById(Arrays.asList(773, 777));
        ArrayList<HintSearchEsParam> findALlList = Lists.newArrayList(allList);
        hintSearchRepository.deleteAll(findALlList);
        log.info("批量删除ES成功");
    }

    public BaseResponse queryAllEs() {
        BaseResponse baseResponse = new BaseResponse();
        List<HintSearchEsParam> resultList = new ArrayList<>();
        Iterable<HintSearchEsParam> allList = hintSearchRepository.findAll();
        allList.forEach(
                n -> resultList.add(n)
        );

        return baseResponse.success(resultList);
    }

    public BaseResponse queryAllEsByIdList() {
        BaseResponse baseResponse = new BaseResponse();
        List<HintSearchEsParam> resultList = new ArrayList<>();
        Iterable<HintSearchEsParam> allList = hintSearchRepository.findAllById(Arrays.asList(10000, 773, 777));
        allList.forEach(
                n -> resultList.add(n)
        );

        return baseResponse.success(resultList);
    }

}
