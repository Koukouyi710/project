package com.neuedu.service.impl;


import com.neuedu.dao.ProductMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    ProductMapper productMapper;

    @Override
    public int addProduct(Product product) throws MyException {
        if(product.getName()==null||product.getName().equals("")){
            throw  new MyException("添加失败：商品名称不能为空");
        }
        if(product.getPrice()==null||product.getPrice().equals("")){
            throw  new MyException("添加失败：请设置商品价格");
        }
        if(product.getStock()==null||product.getStock().equals("")){
            throw  new MyException("添加失败：请设置商品库存");
        }
        return productMapper.insert(product);
    }

    @Override
    public int deleteProduct(int productId) throws MyException {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int updateProduct(Product product) throws MyException {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public List<Product> findAll() throws MyException {
        return productMapper.selectAll();
    }

    @Override
    public Product findProductById(int productId) {
        return productMapper.selectByPrimaryKey(productId);
    }
}
