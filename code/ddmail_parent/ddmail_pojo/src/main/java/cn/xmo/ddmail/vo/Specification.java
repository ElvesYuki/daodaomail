package cn.xmo.ddmail.vo;

import cn.xmo.ddmail.pojo.TbSpecification;
import cn.xmo.ddmail.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 17:31 2019/7/23
 * @Modified By:
 */
public class Specification implements Serializable {

    private TbSpecification spec;

    private List<TbSpecificationOption> optionList;

    public Specification() {
    }

    public Specification(TbSpecification spec, List<TbSpecificationOption> optionList) {
        this.spec = spec;
        this.optionList = optionList;
    }

    public TbSpecification getSpec() {
        return spec;
    }

    public void setSpec(TbSpecification spec) {
        this.spec = spec;
    }

    public List<TbSpecificationOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<TbSpecificationOption> optionList) {
        this.optionList = optionList;
    }
}
