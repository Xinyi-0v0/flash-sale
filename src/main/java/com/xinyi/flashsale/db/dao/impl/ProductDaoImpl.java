package com.xinyi.flashsale.db.dao.impl;

import com.xinyi.flashsale.db.dao.ProductDao;

import com.xinyi.flashsale.db.mappers.ProductMapper;
import com.xinyi.flashsale.db.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean save(Product product) {
        try {
            productMapper.insert(product);
            return true;
        } catch (ArithmeticException e) {
            return false;
        }
    }

    @Override
    public Product getById(long productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        System.out.println(product.getId());
        System.out.println(product.getProductName());
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productMapper.getAllProducts();
    }

    @Override
    public boolean delete(long productId) {
        try {
            productMapper.deleteByPrimaryKey(productId);
            return true;
        } catch (ArithmeticException e) {
            return false;
        }

    }
}
