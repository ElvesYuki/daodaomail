package cn.xmo.ddmail.sellergoods.service.impl;
import java.util.List;

import cn.xmo.ddmail.mapper.TbSpecificationMapper;
import cn.xmo.ddmail.mapper.TbSpecificationOptionMapper;
import cn.xmo.ddmail.pojo.TbSpecification;
import cn.xmo.ddmail.pojo.TbSpecificationExample;
import cn.xmo.ddmail.pojo.TbSpecificationOption;
import cn.xmo.ddmail.pojo.TbSpecificationOptionExample;
import cn.xmo.ddmail.sellergoods.service.SpecificationService;
import cn.xmo.ddmail.vo.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import entity.PageResult;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 17:06 2019/7/23
 * @Modified By:
 */
@Service
@Transactional
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;

	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		if (null == specification.getSpec().getId()) {
			//1、保存规格主表，返回主键值
			specificationMapper.insert(specification.getSpec());
			//2、循环保存规格从表
			for (TbSpecificationOption option : specification.getOptionList()) {
				option.setSpecId(specification.getSpec().getId());
				specificationOptionMapper.insert(option);
			}
		}else {
			specificationMapper.updateByPrimaryKey(specification.getSpec());
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(specification.getSpec().getId());
			specificationOptionMapper.deleteByExample(example);
			for (TbSpecificationOption option : specification.getOptionList()) {
				option.setSpecId(specification.getSpec().getId());
				specificationOptionMapper.insert(option);
			}
		}

	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbSpecification specification){
		specificationMapper.updateByPrimaryKey(specification);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		TbSpecification spec = specificationMapper.selectByPrimaryKey(id);
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<TbSpecificationOption> optionList = specificationOptionMapper.selectByExample(example);
		return new Specification(spec,optionList);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			specificationOptionMapper.deleteByExample(example);
			specificationMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		TbSpecificationExample.Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
