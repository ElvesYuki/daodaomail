package cn.xmo.ddmail.mapper;

import cn.xmo.ddmail.pojo.TbProvinces;
import cn.xmo.ddmail.pojo.TbProvincesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbProvincesMapper {
    long countByExample(TbProvincesExample example);

    int deleteByExample(TbProvincesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbProvinces record);

    int insertSelective(TbProvinces record);

    List<TbProvinces> selectByExample(TbProvincesExample example);

    TbProvinces selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbProvinces record, @Param("example") TbProvincesExample example);

    int updateByExample(@Param("record") TbProvinces record, @Param("example") TbProvincesExample example);

    int updateByPrimaryKeySelective(TbProvinces record);

    int updateByPrimaryKey(TbProvinces record);
}