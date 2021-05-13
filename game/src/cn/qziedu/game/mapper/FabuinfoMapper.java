package cn.qziedu.game.mapper;

import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.FabuinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FabuinfoMapper {
    long countByExample(FabuinfoExample example);

    int deleteByExample(FabuinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fabuinfo record);

    int insertSelective(Fabuinfo record);

    List<Fabuinfo> selectByExample(FabuinfoExample example);

    Fabuinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fabuinfo record, @Param("example") FabuinfoExample example);

    int updateByExample(@Param("record") Fabuinfo record, @Param("example") FabuinfoExample example);

    int updateByPrimaryKeySelective(Fabuinfo record);

    int updateByPrimaryKey(Fabuinfo record);
}