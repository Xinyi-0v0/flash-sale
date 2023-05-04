package com.xinyi.flashsale.service;

import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Product;

import java.util.List;

public interface ProductService {

    public void addNewProduct(Product product);
    public Product getByProductId(long productId);

    public List<Product> getAllProducts();

    public void deleteProductById(long productId);


}
