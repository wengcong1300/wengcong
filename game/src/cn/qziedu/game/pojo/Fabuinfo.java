package cn.qziedu.game.pojo;

import java.util.Date;

public class Fabuinfo {
    private Integer id;

    private String gamename;

    private String miaoshu;

    private String guize;

    private Date time1;

    private Date time2;

    private Date time3;

    private Date time4;

    private Integer userid;

    private Integer buildid;

    private Integer number;

    private Integer money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu == null ? null : miaoshu.trim();
    }

    public String getGuize() {
        return guize;
    }

    public void setGuize(String guize) {
        this.guize = guize == null ? null : guize.trim();
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    public Date getTime3() {
        return time3;
    }

    public void setTime3(Date time3) {
        this.time3 = time3;
    }

    public Date getTime4() {
        return time4;
    }

    public void setTime4(Date time4) {
        this.time4 = time4;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBuildid() {
        return buildid;
    }

    public void setBuildid(Integer buildid) {
        this.buildid = buildid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}