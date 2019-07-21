package cn.xmo.ddmail.manager.controller;

import cn.xmo.ddmail.pojo.TbBrand;
import cn.xmo.ddmail.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Reference;
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
}
