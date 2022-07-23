package com.xy.work;

public class BoxDetail {

    private String boxCode;
    private int boxCount;

    public BoxDetail() {
    }

    public BoxDetail(String boxCode, int boxCount) {
        this.boxCode = boxCode;
        this.boxCount = boxCount;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public int getBoxCount() {
        return boxCount;
    }

    public void setBoxCount(int boxCount) {
        this.boxCount = boxCount;
    }
}
