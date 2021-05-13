package cn.qziedu.game.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomGroup {
	
	public static void random(List<Object> c) {
		
		List<Object> d=new ArrayList<Object>();
		System.out.println(c.size());
		int n=0;
		while(c.size()>5) {
			for (int i = 0; i < 5; i++) {
				int a=(int) (Math.random()*c.size());
				d.add(c.get(a));
				//System.out.print(" "+c.get(a));
				c.remove(a);	
			}
			System.out.println(d);
			d.clear();
		}
		
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}
	}
	
//	public static void main(String[] args) {
//		List<Object> c =new ArrayList<>();
//		for (int i = 0; i < 99; i++) {
//			c.add(i);
//		}
//		random(c);
//	}
	

}
