package com.fct.controller;

import com.fct.entity.Product;
import com.fct.vos.CollectionsVO;
import com.fct.vos.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Slf4j
//@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private int port;

    // 定义一个接收零散类型参数接口 queryString
    @GetMapping("test")
    public String test(String name, Integer age){
        log.info("name: {}, age: {}",name, age);
        return "test ok...端口号为:" + port;
    }

    // 定义一个接收零散类型参数接口 路径
    @GetMapping("test1/{id}/{name}")
    public String test1(@PathVariable("id") Integer id, @PathVariable("name") String name){
        log.info("id: {}, name: {}", id, name);
        return "test1 ok...端口号为:" + port;
    }

    // 定义一个接收对象型参数的接口
    @PostMapping("test2")
    public String test2(@RequestBody Product product){
        log.info(product.toString());
        return "test2 ok...端口号为:" + port;
    }

    // 定义一个接收数组类型参数的接口
    @GetMapping("test3")
    public String test3(String[] ids){
        for(String id : ids){
            log.info("id: {}", id);
        }

        return "test3 ok...端口号为:" + port;
    }

    // 定义一个接收集合类型的接口,可使用vo接收
    @GetMapping("test4")
    public String test4(@RequestParam("ids") List<String> ids){
        ids.forEach(id ->{
            log.info("id: {}", id);
        });
        return "test4 ok...端口号为:" + port;
    }

    // 返回对象类型
    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        log.info("product被调用");
        return new Product(1001, "衬衫", 9.15, new Date());
    }

    // 返回集合类型
    @GetMapping("products")
    public List<Product> products(Integer categoryId){
        log.info("查询到产品集合");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1001, "卫衣", 160.00, new Date()));
        products.add(new Product(1002, "牛仔裤", 150.00, new Date()));
        products.add(new Product(1003, "运动鞋", 400.00, new Date()));

        return products;
    }

    // 返回复合类型数据
    @GetMapping("productvo")
    public ProductVO getProductByIdAndPage(int page, int rows, int categoryId){
        ProductVO productVO = new ProductVO();
        productVO.setRows(1000l);
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1001, "卫衣", 160.00, new Date()));
        products.add(new Product(1002, "牛仔裤", 150.00, new Date()));
        products.add(new Product(1003, "运动鞋", 400.00, new Date()));
        productVO.setProducts(products);

        return productVO;
    }

    // 返回map数据
    @GetMapping("productmap")
    public Map<String, Object> getMap(int page, int rows, int categoryId){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1001, "卫衣", 160.00, new Date()));
        products.add(new Product(1002, "牛仔裤", 150.00, new Date()));
        products.add(new Product(1003, "运动鞋", 400.00, new Date()));
        Map<String, Object> map = new HashMap<>();
        map.put("total", 1000);
        map.put("rows", products);

        return map;
    }

    @GetMapping("/product")
    public String product(HttpServletRequest request, String color){
        String headers = request.getHeader("User-Name");
        log.info(headers);
        log.info("请求参数color为"+ color);
        log.info("product demo...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "product被调用...端口号为:" + port;
    }


}
