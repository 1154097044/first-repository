package com.xy.work;

public class Model {

    public static final int TITLE = 0;
    public static final int DETAIL = 1;

    private int type;
    private int data;
    private String text;
    private String trayType;
    public Model() {
    }

    public Model(int type, int data, String text,String trayType) {
        this.type = type;
        this.data = data;
        this.text = text;
        this.trayType = trayType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTrayType() {
        return trayType;
    }

    public void setTrayType(String trayType) {
        this.trayType = trayType;
    }
}
