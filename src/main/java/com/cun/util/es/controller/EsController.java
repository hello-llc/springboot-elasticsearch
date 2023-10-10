package com.cun.util.es.controller;


import com.cun.util.es.module.BaseResponse;
import com.cun.util.es.module.DelEsIndexParam;
import com.cun.util.es.module.QueryHintParam;
import com.cun.util.es.service.EsService;
import com.cun.util.es.utils.LoggerUtilFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cun/es/")
@Api(tags = "ES相关接口")
public class EsController {
    @Autowired
    private EsService esService;

    private static Logger log = LoggerUtilFactory.getLoggerUtil();

    @RequestMapping(value = "del-es-index", method = RequestMethod.POST)
    @ApiOperation("根据名称删除ES索引")
    public BaseResponse delEsIndex(@RequestBody DelEsIndexParam delEsIndexParam) {
        return esService.delEsIndex(delEsIndexParam);
    }

    @RequestMapping(value = "insert-es", method = RequestMethod.GET)
    @ApiOperation("数据写入ES")
    public BaseResponse insertEsIndex() {
        return esService.insertEsIndex();
    }

    @RequestMapping(value = "batch-insert-es", method = RequestMethod.GET)
    @ApiOperation("批量数据写入ES")
    public BaseResponse batchInsertEsIndex() {
        return esService.batchInsertEsIndex();
    }

    @RequestMapping(value = "query-es-index", method = RequestMethod.POST)
    @ApiOperation("模糊查询ES")
    public BaseResponse queryEsIndex(@RequestBody QueryHintParam queryHintParam) {
        return esService.queryEsIndex(queryHintParam);
    }

    @RequestMapping(value = "query-es-by-id", method = RequestMethod.POST)
    @ApiOperation("根据ID查询ES")
    public void queryEsById(@RequestBody QueryHintParam queryHintParam) {
        esService.queryEsById(queryHintParam);
    }

    @RequestMapping(value = "query-all-es", method = RequestMethod.GET)
    @ApiOperation("批量查询ES")
    public BaseResponse queryAllEs() {
        return esService.queryAllEs();
    }

    @RequestMapping(value = "query-es-batch-id", method = RequestMethod.GET)
    @ApiOperation("根据ID集合批量查询ES")
    public BaseResponse queryEsBatchId() {
        return esService.queryAllEsByIdList();
    }

    @RequestMapping(value = "del-es-by-id", method = RequestMethod.POST)
    @ApiOperation("根据ID删除ES")
    public void delEsById(@RequestBody QueryHintParam queryHintParam) {
        esService.deleteEsById(queryHintParam);
    }

    @RequestMapping(value = "del-es-batch-id", method = RequestMethod.GET)
    @ApiOperation("根据ID集合批量删除ES")
    public void delEsBatchId() {
        esService.batchDeleteEs();
    }

    @RequestMapping(value = "edit-es-by-id", method = RequestMethod.POST)
    @ApiOperation("根据ID更新ES")
    public void editEsById(@RequestBody QueryHintParam queryHintParam) {
        esService.updateEsById(queryHintParam);
    }

    @RequestMapping(value = "edit-es-batch-id", method = RequestMethod.GET)
    @ApiOperation("根据ID集合批量更新ES")
    public void editEsBatchId() {
        esService.batchUpdateEs();
    }

}
