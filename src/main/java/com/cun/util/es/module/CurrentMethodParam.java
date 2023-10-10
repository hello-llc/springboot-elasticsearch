package com.cun.util.es.module;


import lombok.Data;

import java.io.Serializable;

@Data
public class CurrentMethodParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fileName;
    private String className;
    private String methodName;
    private int lineNumber;

}
