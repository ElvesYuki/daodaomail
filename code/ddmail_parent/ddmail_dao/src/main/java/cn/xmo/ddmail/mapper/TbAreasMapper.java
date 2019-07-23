package cn.xmo.ddmail.mapper;

import cn.xmo.ddmail.pojo.TbAreas;
import cn.xmo.ddmail.pojo.TbAreasExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAreasMapper {
    long countByExample(TbAreasExample example);

    int deleteByExample(TbAreasExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAreas record);

    int insertSelective(TbAreas record);

    List<TbAreas> selectByExample(TbAreasExample example);

    TbAreas selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAreas record, @Param("example") TbAreasExample example);

    int updateByExample(@Param("record") TbAreas record, @Param("example") TbAreasExample example);

    int updateByPrimaryKeySelective(TbAreas record);

    int updateByPrimaryKey(TbAreas record);
}