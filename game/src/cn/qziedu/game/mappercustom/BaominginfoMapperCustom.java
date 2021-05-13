package cn.qziedu.game.mappercustom;

import java.util.List;

import cn.qziedu.game.pojo.Baominginfo;

public interface BaominginfoMapperCustom {
	
	/**
	 * 根据fabuinfoid查询报名信息
	 * @param fabuinfoid
	 * @return
	 */
	List<Baominginfo> selectBaominginfoByFabuinfoid(int fabuinfoid);

}
