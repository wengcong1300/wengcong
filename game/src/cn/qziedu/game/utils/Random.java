package cn.qziedu.game.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Random {
	public void rand(int i) {
		
	}

	public static void main(String[] args) {
		List<Object> num=new ArrayList<Object>();
		List<Object> num2=new ArrayList<Object>();
		for(int i=1;i<100;i++) {
			num.add(i);
		}
		int n=num.size();
		int duochu=n%5;
		for(int i=0;i<duochu;i++) {
			//对list集合下标进行随机
			int ran=(int) (Math.random()*n);
			System.out.println("\t"+num.get(ran));
			//对随机到的对象进行移除
			num.remove(ran);
			//移除对象后重新计算list集合对象数量
			n=num.size();
		}
		int i=1;
		a:while(true) {	
			for(int k=0;k<5;k++) {
				//对list集合下标进行随机
				int ran=(int) (Math.random()*n);
				num2.add(num.get(ran));
				System.out.print("\t"+num.get(ran));
				//对随机到的对象进行移除
				num.remove(ran);
				//移除对象后重新计算list集合对象数量
				n=num.size();
				//如果list集合没有对象退出循环
				if(n==0) {
					break a;
				}
			}
			System.out.println();
		}
		
		
		

	}

}
