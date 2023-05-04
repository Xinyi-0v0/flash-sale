package com.xinyi.flashsale.controller;

import com.xinyi.flashsale.db.dao.ProductDao;
import com.xinyi.flashsale.db.model.Product;
import com.xinyi.flashsale.exception.BusinessException;
import com.xinyi.flashsale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private ProductService productService;

    @GetMapping("/health")
    public String test(){
        return "Healthy Connection!";
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        if (id < 0) {
            throw new BusinessException("id is invalid",0);
        }
        Product res = productService.getByProductId(id);
        return res;
    }


    @PostMapping
    public String AddProduct(@RequestBody Product product){
        System.out.println(product.getProductName());
        System.out.println(product.getProductDesc());
        productService.addNewProduct(product);
        return "successfully";
    }


    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
       productService.deleteProductById(id);
    }



}
