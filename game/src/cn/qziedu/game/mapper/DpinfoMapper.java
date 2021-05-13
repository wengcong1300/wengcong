package cn.qziedu.game.mapper;

import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.DpinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DpinfoMapper {
    long countByExample(DpinfoExample example);

    int deleteByExample(DpinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dpinfo record);

    int insertSelective(Dpinfo record);

    List<Dpinfo> selectByExample(DpinfoExample example);

    Dpinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dpinfo record, @Param("example") DpinfoExample example);

    int updateByExample(@Param("record") Dpinfo record, @Param("example") DpinfoExample example);

    int updateByPrimaryKeySelective(Dpinfo record);

    int updateByPrimaryKey(Dpinfo record);
}