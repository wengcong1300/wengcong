package cn.qziedu.game.mappercustom;

import java.util.List;

import cn.qziedu.game.pojo.Baominginfo;

public interface BaominginfoMapperCustom {
	
	List<Baominginfo> selectBaominginfoByFabuinfoid(int fabuinfoid);

}
