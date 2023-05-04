package com.xinyi.flashsale.service.impl;

import com.xinyi.flashsale.db.dao.ProductDao;
import com.xinyi.flashsale.db.model.Activity;
import com.xinyi.flashsale.db.model.Product;
import com.xinyi.flashsale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void addNewProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public Product getByProductId(long productId) {
        return productDao.getById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public void deleteProductById(long productId) {
        productDao.delete(productId);
    }


}
