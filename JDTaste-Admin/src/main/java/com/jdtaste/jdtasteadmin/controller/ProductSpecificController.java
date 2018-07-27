package com.jdtaste.jdtasteadmin.controller;

import com.jdtaste.common.domain.WrapMapper;
import com.jdtaste.common.domain.Wrapper;
import com.jdtaste.mybatis.domain.ProductSpecific;
import com.jdtaste.mybatis.domain.ProductSpecificTmp;
import com.jdtaste.service.IProductSpecificService;
import com.jdtaste.service.IProductSpecificTmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtasteadmin.controller
 * @Author: xuweichao
 * @CreateTime: 2018-07-18 15:09
 * @Description: 商品规格
 */
@Slf4j
@RestController
@RequestMapping("specific")
public class ProductSpecificController {
    @Autowired
    IProductSpecificService productSpecificService;
    @Autowired
    IProductSpecificTmpService productSpecificTmpService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Wrapper getProductSpecificList() {
        log.info("获取商品规格列表==>>");
        List<ProductSpecific> list = productSpecificService.getProductSpecificList();
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Wrapper saveProductSpecific(@RequestBody ProductSpecific productSpecific) {
        log.info("商品规格保存修改==>>" + productSpecific);
        int result = productSpecificService.saveProductSpecific(productSpecific);
        return getProductSpecificList();
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public Wrapper deteteProductSpecific(@PathVariable int id) {
        log.info("商品规格删除==>>" + id);
        int result = productSpecificService.deleteProductSpecific(id);
        return getProductSpecificList();
    }

    @RequestMapping(value = "allTmp", method = RequestMethod.GET)
    public Wrapper getProductSpecificTmpList() {
        log.info("获取商品规格模板列表==>>");
        List<ProductSpecificTmp> list = productSpecificTmpService.getProductSpecificTmpList();
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
    }

    @RequestMapping(value = "addTmp", method = RequestMethod.POST)
    public Wrapper saveProductSpecific(@RequestBody ProductSpecificTmp productSpecificTmp) {
        log.info("商品规格模板保存修改==>>" + productSpecificTmp);
        int result = productSpecificTmpService.saveProductSpecificTmp(productSpecificTmp);
        return getProductSpecificTmpList();
    }

    @RequestMapping(value = "delTmp/{id}", method = RequestMethod.GET)
    public Wrapper deleteProductSpecific(@PathVariable int id) {
        log.info("商品规格模板删除==>>" + id);
        int result = productSpecificTmpService.deleteProductSpecificTmp(id);
        return getProductSpecificTmpList();
    }
}
