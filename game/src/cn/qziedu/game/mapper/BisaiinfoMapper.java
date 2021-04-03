package cn.qziedu.game.mapper;

import cn.qziedu.game.pojo.Bisaiinfo;
import cn.qziedu.game.pojo.BisaiinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BisaiinfoMapper {
    long countByExample(BisaiinfoExample example);

    int deleteByExample(BisaiinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bisaiinfo record);

    int insertSelective(Bisaiinfo record);

    List<Bisaiinfo> selectByExample(BisaiinfoExample example);

    Bisaiinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bisaiinfo record, @Param("example") BisaiinfoExample example);

    int updateByExample(@Param("record") Bisaiinfo record, @Param("example") BisaiinfoExample example);

    int updateByPrimaryKeySelective(Bisaiinfo record);

    int updateByPrimaryKey(Bisaiinfo record);
}