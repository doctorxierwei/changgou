package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
//        通过主键查询
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
//        方法中但凡带有selective 会忽略空值
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
             Example example =createExample(brand);
        return brandMapper.selectByExample(example);
    }
//分页查询
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
//PageHelper.startPage(page,size);  实现分页，后面的查询紧跟集合查询
//page  当前页  size  每页显示多少条
        PageHelper.startPage(page,size);
//        查询集合
        List<Brand> brands=brandMapper.selectAll() ;

        return new PageInfo<Brand>(brands);
    }




    /*
    * 构建条件判断
    * */
    public  Example createExample(Brand brand){
        Example example =new Example(Brand.class);
        Example.Criteria criteria =example.createCriteria();
        if(brand!=null){
//            brand.name!=null根据名字模糊搜索where name like '%华为%'
            if(!StringUtils.isEmpty(brand.getName())){
                /*
                 *     1.brand的属性名
                 *     2.占位符参数，搜索的条件
                 * */
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
//             brand.letter!=null根据首字母搜索
        }
        return example;
    }

}
