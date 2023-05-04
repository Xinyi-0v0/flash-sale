package com.xinyi.flashsale.db.dao;


import com.xinyi.flashsale.db.model.Product;

import java.util.List;

public interface ProductDao {

    public boolean save(Product product);
    public Product getById(long productId);

    public List<Product> getAll();

    public boolean delete(long productId);
}
