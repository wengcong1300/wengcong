package cn.qziedu.game.mapper;

import cn.qziedu.game.pojo.Zuduiinfo;
import cn.qziedu.game.pojo.ZuduiinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZuduiinfoMapper {
    long countByExample(ZuduiinfoExample example);

    int deleteByExample(ZuduiinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zuduiinfo record);

    int insertSelective(Zuduiinfo record);

    List<Zuduiinfo> selectByExample(ZuduiinfoExample example);

    Zuduiinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zuduiinfo record, @Param("example") ZuduiinfoExample example);

    int updateByExample(@Param("record") Zuduiinfo record, @Param("example") ZuduiinfoExample example);

    int updateByPrimaryKeySelective(Zuduiinfo record);

    int updateByPrimaryKey(Zuduiinfo record);
}