package com.changgou.dao;

import com.changgou.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

/*
* Dao是圆通通用mapper,Dao接口需要继承tk.mybatis.mapper.common.Mapper接口
* 增加数据，调用Mapper.insert()
* 增加数据，调用Mapper.insertSelective()
* */
public interface BrandMapper extends Mapper<Brand> {
}
