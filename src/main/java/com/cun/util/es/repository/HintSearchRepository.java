package com.cun.util.es.repository;


import com.cun.util.es.module.HintSearchEsParam;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HintSearchRepository extends ElasticsearchRepository<HintSearchEsParam, Integer> {

}
