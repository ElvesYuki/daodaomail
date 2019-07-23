package cn.xmo.ddmail.sellergoods.service;

import cn.xmo.ddmail.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 20:52 2019/7/19
 * @Modified By:
 */
public interface BrandService {

     List<TbBrand> findAll();

     PageResult<TbBrand> findPage(int page, int size);

    void save(TbBrand brand);

    TbBrand findOne(Long id);

    void delete(String ids);
}
