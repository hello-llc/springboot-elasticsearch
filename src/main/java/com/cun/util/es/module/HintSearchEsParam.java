package com.cun.util.es.module;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "cun_es_demo")
public class HintSearchEsParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String table_name;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String source_table;
    @Field(type = FieldType.Long)
    private Long table_id;

}
