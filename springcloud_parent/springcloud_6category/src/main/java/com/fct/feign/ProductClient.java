package com.fct.feign;

import com.fct.entity.Product;
import com.fct.vos.ProductVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value="PRODUCT")
public interface ProductClient {

    @GetMapping("product")
    String product();

    @GetMapping("test")
    String test(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @GetMapping("test1/{id}/{name}")
    String test1(@PathVariable("id") Integer id, @PathVariable("name") String name);

    @PostMapping("test2")
    String test2(@RequestBody Product product);

    @GetMapping("test3")
    String test3(@RequestParam("ids") String[] ids);

    @GetMapping("test4")
    String test4(@RequestParam("ids") List<String> ids);

    @GetMapping("product/{id}")
    Product getProduct(@PathVariable("id") Integer id);

    @GetMapping("products")
    List<Product> products(@RequestParam("categoryId") Integer categoryId);

    @GetMapping("productvo")
    ProductVO getProductByIdAndPage(@RequestParam("page") int page, @RequestParam("rows") int rows, @RequestParam("categoryId") int categoryId);

    @GetMapping("productmap")
    String getMap(@RequestParam("page") int page, @RequestParam("rows") int rows, @RequestParam("categoryId") int categoryId);
}
