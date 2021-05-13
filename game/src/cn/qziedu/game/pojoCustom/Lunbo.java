package cn.qziedu.game.pojoCustom;
/**
 * 姓名，参赛总次数，胜利总次数，奖金总额
 * @author 翁聪
 *
 */
public class Lunbo {
	private String name;//用户名
	private int csnum;//参赛总次数
	private int winnum;//胜利总次数
	private int moneynum;//奖金总额
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCsnum() {
		return csnum;
	}
	public void setCsnum(int csnum) {
		this.csnum = csnum;
	}
	public int getWinnum() {
		return winnum;
	}
	public void setWinnum(int winnum) {
		this.winnum = winnum;
	}
	public int getMoneynum() {
		return moneynum;
	}
	public void setMoneynum(int moneynum) {
		this.moneynum = moneynum;
	}
	

}
