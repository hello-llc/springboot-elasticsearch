package com.cun.util.es.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "删除ES索引参数")
public class DelEsIndexParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("索引名称")
    private String indexName;

}
