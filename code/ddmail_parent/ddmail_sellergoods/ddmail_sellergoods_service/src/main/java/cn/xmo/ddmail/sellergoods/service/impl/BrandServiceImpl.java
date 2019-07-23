package cn.xmo.ddmail.sellergoods.service.impl;

import cn.xmo.ddmail.mapper.TbBrandMapper;
import cn.xmo.ddmail.pojo.TbBrand;
import cn.xmo.ddmail.sellergoods.service.BrandService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 20:52 2019/7/19
 * @Modified By:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult<TbBrand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<TbBrand> pageResult = (Page<TbBrand>)tbBrandMapper.selectByExample(null);
        return new PageResult<>(pageResult.getTotal(),pageResult.getResult());
    }

    @Override
    public void save(TbBrand brand) {
        if (null == brand.getId()){
            tbBrandMapper.insert(brand);
        }else {
            tbBrandMapper.updateByPrimaryKey(brand);
        }

    }

    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(String ids) {
        String[] idsArr = ids.split(",");
        for (String id :idsArr ){
            tbBrandMapper.deleteByPrimaryKey(Long.valueOf(id));
        }
    }
}
