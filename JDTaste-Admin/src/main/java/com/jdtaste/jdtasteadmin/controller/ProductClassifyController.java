package com.jdtaste.jdtasteadmin.controller;

import com.jdtaste.common.domain.WrapMapper;
import com.jdtaste.common.domain.Wrapper;
import com.jdtaste.mybatis.domain.ProductClassify;
import com.jdtaste.mybatis.domain.ProductClassifySelector;
import com.jdtaste.service.IProductClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtasteadmin.controller
 * @Author: xuweichao
 * @CreateTime: 2018-07-12 15:24
 * @Description: 产品分类
 */
@Slf4j
@RestController
@RequestMapping("/classify")
public class ProductClassifyController {

    @Resource
    IProductClassifyService productClassifyService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Wrapper saveClassify(@RequestBody ProductClassify productClassify) {
        log.info("分类数据保存==>>" + productClassify);
        productClassifyService.saveProductClassify(productClassify);
        return getAllClassify();
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Wrapper getAllClassify() {
        log.info("获取所有分类数据==>>");

        List<ProductClassify> list = productClassifyService.getAllProductClassify();
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public Wrapper delteClassify(@PathVariable int id) {
        log.info("删除分类数据==>>" + id);
        productClassifyService.delProductClassify(id);
        return getAllClassify();
    }

    /**
     *  级联选择
     * @return
     */
    @RequestMapping(value = "select", method = RequestMethod.GET)
    public Wrapper getClassifyselect() {
        log.info("获取所有分类数据==>>");

        List<ProductClassifySelector> list = productClassifyService.getProductClassifyselectList();
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
    }

}
