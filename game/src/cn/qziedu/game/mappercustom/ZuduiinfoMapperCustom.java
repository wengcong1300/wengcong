package cn.qziedu.game.mappercustom;

import java.util.List;

import cn.qziedu.game.pojo.Zuduiinfo;

public interface ZuduiinfoMapperCustom {
	/**
	 * 根据fabuinfoid查询获胜次数winnum,并进行降序排序
	 * @return winnum最大的获胜次数
	 */
    int selectZuduiinfoReturnWinnum(int fabuinfoid);
    
    /**
     * 根据fabuinfoid查询排行榜
     * @param fabuinfoid
     * @return
     */
    List<Zuduiinfo> selectZuduiinfoByfabuinfoid(int fabuinfoid);
}