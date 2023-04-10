package com.fct.controller;

import com.alibaba.fastjson.JSONObject;
import com.fct.entity.Product;
import com.fct.feign.ProductClient;
import com.fct.vos.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class CategoryController {

    @Resource
    private ProductClient productClient;

    @GetMapping("category")
    public String category(){
        log.info("category demo...");
//        String product = productClient.product();
//        String product = productClient.test("zhangsan", 22);
//        String product = productClient.test1(1001, "lisi");
//        String product = productClient.test2(new Product(1001, "衬衫", 9.15, new Date()));
//        String product = productClient.test3(new String[]{"21", "33", "18"});
//        List ids = new ArrayList<String>();
//        ids.add("11");
//        ids.add("21");
//        ids.add("31");
//        String product = productClient.test4(ids);
//        Product product = productClient.getProduct(1001);
//        ProductVO productByIdAndPage = productClient.getProductByIdAndPage(1, 2, 3);
//        List<Product> products = productByIdAndPage.getProducts();
//        productByIdAndPage.getRows();
        String map = productClient.getMap(1, 2, 3);
        JSONObject jb = JSONObject.parseObject(map);
        Object rows = jb.get("rows");

//        System.out.println(map.get("total"));
//
//        Object rows = map.get("rows");

        String toJSONString = JSONObject.toJSONString(rows);
        List<Product> products = JSONObject.parseArray(toJSONString, Product.class);
        for (Product product : products) {
            log.info("product : {}", product);
        }
        return map;
    }
}
