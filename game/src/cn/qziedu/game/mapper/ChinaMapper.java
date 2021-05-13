package cn.qziedu.game.mapper;

import cn.qziedu.game.pojo.China;
import cn.qziedu.game.pojo.ChinaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChinaMapper {
    long countByExample(ChinaExample example);

    int deleteByExample(ChinaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(China record);

    int insertSelective(China record);

    List<China> selectByExample(ChinaExample example);

    China selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") China record, @Param("example") ChinaExample example);

    int updateByExample(@Param("record") China record, @Param("example") ChinaExample example);

    int updateByPrimaryKeySelective(China record);

    int updateByPrimaryKey(China record);
    
    China selectChinaByName(String name);
}