package cn.xmo.ddmail.manager.controller;

import cn.xmo.ddmail.pojo.TbBrand;
import cn.xmo.ddmail.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 21:17 2019/7/19
 * @Modified By:
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/findPage/{page}/{size}")
    public PageResult<TbBrand> findPage(@PathVariable("page") int page, @PathVariable("size")int size ){
        return brandService.findPage(page,size);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody TbBrand brand){
        try{
            brandService.save(brand);
            return new Result(true,"保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"保存失败!");
        }
    }

    @RequestMapping("/findOne/{id}")
    public TbBrand findOne(@PathVariable("id") Long id){
        return brandService.findOne(id);
    }

    @RequestMapping("/delete/{ids}")
    public Result delete(@PathVariable("ids") String ids){
        try{
            brandService.delete(ids);
            return new Result(true,"删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败!");
        }
    }
}
