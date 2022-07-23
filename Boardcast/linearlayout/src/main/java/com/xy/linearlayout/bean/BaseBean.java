package com.xy.linearlayout.bean;

public class BaseBean {

    public static final int TAIL_BOX = 0;
    public static final int WHOLE_TRAY = 1;
    public static final int WHOLE_BOX = 2;

    private int type;
    private String trayCode;
    public BaseBean() {
    }

    public BaseBean(int type, String trayCode) {
        this.type = type;
        this.trayCode = trayCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTrayCode() {
        return trayCode;
    }

    public void setTrayCode(String trayCode) {
        this.trayCode = trayCode;
    }
}
