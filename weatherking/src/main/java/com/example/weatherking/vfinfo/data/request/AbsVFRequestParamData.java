package com.example.weatherking.vfinfo.data.request;

public abstract class AbsVFRequestParamData extends AbsVFRequestParam {
    // 발표일자 (yyyyMMdd)
    protected String base_date;
    // 발표시각
    protected String base_time;
    // 예보지점 x좌표
    protected Integer nx;
    // 예보지점 y좌표
    protected Integer ny;

    public String getBase_date() {
        return base_date;
    }

    public void setBase_date(String base_date) {
        this.base_date = base_date;
    }

    public String getBase_time() {
        return base_time;
    }

    public void setBase_time(String base_time) {
        this.base_time = base_time;
    }

    public Integer getNx() {
        return nx;
    }

    public void setNx(Integer nx) {
        this.nx = nx;
    }

    public Integer getNy() {
        return ny;
    }

    public void setNy(Integer ny) {
        this.ny = ny;
    }

    @Override
    public String toString() {
        return "AbsVFRequestParamData{" +
                "base_date='" + base_date + '\'' +
                ", base_time='" + base_time + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
