package cn.qziedu.game.mapper;

import cn.qziedu.game.pojo.Baominginfo;
import cn.qziedu.game.pojo.BaominginfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaominginfoMapper {
    long countByExample(BaominginfoExample example);

    int deleteByExample(BaominginfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Baominginfo record);

    int insertSelective(Baominginfo record);

    List<Baominginfo> selectByExample(BaominginfoExample example);

    Baominginfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Baominginfo record, @Param("example") BaominginfoExample example);

    int updateByExample(@Param("record") Baominginfo record, @Param("example") BaominginfoExample example);

    int updateByPrimaryKeySelective(Baominginfo record);

    int updateByPrimaryKey(Baominginfo record);
}