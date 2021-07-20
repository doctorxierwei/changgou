package com.changgou.controller;


import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 */
@RestController

/*
* 跨域 A域名访问B域名的数据
* 域名或者请求端口或者协议不一致时就属于跨域
* */
@CrossOrigin  //跨域
@RequestMapping(value = "/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
//    查询所有品牌
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询成功",brands);

    }

//    根据主键id查询
    @GetMapping(value="/{id}")
    public Result findById(@PathVariable(value="id")Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK,"根据id查询成功",brand);
    }
    @PostMapping
    public  Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK,"增加品牌成功");

    }
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable (value = "id") Integer id,@RequestBody Brand brand){
          brand.setId(id);
          brandService.update(brand);
        return new Result(true, StatusCode.OK,"修改品牌成功");

    }
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable (value = "id") Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    @PostMapping(value="/search")
    public  Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK,"模糊查询品牌成功",brands);

    }

//    实现分页查询
    @GetMapping(value="/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value="page")Integer page,
                                    @PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(page,size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",pageInfo);

    }

}
