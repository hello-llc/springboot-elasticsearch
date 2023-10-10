package com.cun.util.es.module;

import lombok.Data;

import java.io.Serializable;

@Data
public class HintSearchResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String searchName;
    private Long tableId;
    private String showName;

}
