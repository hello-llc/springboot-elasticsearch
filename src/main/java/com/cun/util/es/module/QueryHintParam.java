package com.cun.util.es.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "最顶上搜索参数")
public class QueryHintParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("查询字符串")
    private String queryString;
    @ApiModelProperty("ID")
    private Integer id;

}
