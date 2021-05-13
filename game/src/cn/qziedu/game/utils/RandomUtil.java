package cn.qziedu.game.utils;

import java.util.HashMap;
import java.util.Set;

public class RandomUtil {
	//随机得到4位数验证码
    public static int getRandNum() {
    	
        return (int)((Math.random()*9+1)*1000);
    }
    
    
    //随机分组参赛人员
//    private Set<StudentVo> randomGetStu(List<StudentVo> studentVos, int backNum, Random random) {
//        Set<StudentVo> newStudents = new HashSet<>();
//        while(newStudents.size() != backNum){
//            int target = random.nextInt(studentVos.size());
//            newStudents.add(studentVos.get(target));
//        }
//        return newStudents;
//    }
    
    
    
//    public static void main(String[] args) {
//    	HashMap<String,String> hashMap = new HashMap<>();
//    	String randMun=null;
//    	for(int i=0;i<10;i++) {
//    		randMun= String.valueOf(RandomUtil.getRandNum());
//        	hashMap.put("code", randMun);
//        	System.out.println(hashMap);
//    	}
//	}
}
