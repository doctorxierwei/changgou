package com.changgou.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
//查询所有
    List<Brand> findAll();

//    根据id查询
    Brand findById(Integer id);

//    添加品牌
    void add(Brand brand);

}
