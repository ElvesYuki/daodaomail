package cn.xmo.ddmail.sellergoods.service.impl;

import cn.xmo.ddmail.mapper.TbBrandMapper;
import cn.xmo.ddmail.pojo.TbBrand;
import cn.xmo.ddmail.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 20:52 2019/7/19
 * @Modified By:
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.findAll();
    }
}
