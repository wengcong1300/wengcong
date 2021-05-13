package cn.qziedu.game.mapper;

import cn.qziedu.game.pojo.Buildinfo;
import cn.qziedu.game.pojo.BuildinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildinfoMapper {
    long countByExample(BuildinfoExample example);

    int deleteByExample(BuildinfoExample example);

    int deleteByPrimaryKey(Integer buildid);

    int insert(Buildinfo record);

    int insertSelective(Buildinfo record);

    List<Buildinfo> selectByExample(BuildinfoExample example);

    Buildinfo selectByPrimaryKey(Integer buildid);

    int updateByExampleSelective(@Param("record") Buildinfo record, @Param("example") BuildinfoExample example);

    int updateByExample(@Param("record") Buildinfo record, @Param("example") BuildinfoExample example);

    int updateByPrimaryKeySelective(Buildinfo record);

    int updateByPrimaryKey(Buildinfo record);
}