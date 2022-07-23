package com.xy.progressbar.bean;

public class Bean {

    private String content;
    private int data;

    public Bean() {
    }

    public Bean(String content, int data) {
        this.content = content;
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
