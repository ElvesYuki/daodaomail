package cn.xmo.ddmail.manager.controller;
import java.util.List;

import cn.xmo.ddmail.pojo.TbSpecificationOption;
import cn.xmo.ddmail.sellergoods.service.SpecificationOptionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.alibaba.dubbo.config.annotation.Reference;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specificationOption")
public class SpecificationOptionController {

	@Reference
	private SpecificationOptionService specificationOptionService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSpecificationOption> findAll(){
		return specificationOptionService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage/{page}/{rows}")
	public PageResult  findPage(@PathVariable("page") int page, @PathVariable("rows")int rows){			
		return specificationOptionService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param specificationOption
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbSpecificationOption specificationOption){
		try {
			specificationOptionService.add(specificationOption);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param specificationOption
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbSpecificationOption specificationOption){
		try {
			specificationOptionService.update(specificationOption);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne/{id}")
	public TbSpecificationOption findOne(@PathVariable("id") Long id){
		return specificationOptionService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public Result delete(@PathVariable("ids") Long [] ids){
		try {
			specificationOptionService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param specificationOption
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search/{page}/{rows}")
	public PageResult search(@RequestBody TbSpecificationOption specificationOption, @PathVariable("page") int page,  @PathVariable("rows") int rows  ){
		return specificationOptionService.findPage(specificationOption, page, rows);		
	}
	
}
