package cn.qziedu.game.pojo;

public class Buildinfo {
    private Integer buildid;

    private String gamename;

    private String miaoshu;

    private String guize;

    private Integer userid;

    public Integer getBuildid() {
        return buildid;
    }

    public void setBuildid(Integer buildid) {
        this.buildid = buildid;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}