package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
//查询所有
    List<Brand> findAll();

//    根据id查询
    Brand findById(Integer id);

//    添加品牌
    void add(Brand brand);
//    根据id修改品牌
    void update(Brand brand);

    void delete(Integer id);
    //  多条件查询
    List<Brand> findList(Brand brand);

   /*
   * 条件搜索
   * page 当前页
   * size  每页显示的条数
   * */
     PageInfo<Brand> findPage(Integer page,Integer size);


}
