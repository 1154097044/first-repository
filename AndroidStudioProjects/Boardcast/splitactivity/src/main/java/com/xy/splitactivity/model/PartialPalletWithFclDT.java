package com.xy.splitactivity.model;

public class PartialPalletWithFclDT{

    /**
     * 拆分任务号
     */
    private String taskCode;
    /**
     * 合单号
     */
    private String receiveCode;
    /**
     * 托盘号
     */
    private String palletCode;

    public PartialPalletWithFclDT() {
    }

    public PartialPalletWithFclDT(String taskCode, String receiveCode, String palletCode) {
        this.taskCode = taskCode;
        this.receiveCode = receiveCode;
        this.palletCode = palletCode;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getReceiveCode() {
        return receiveCode;
    }

    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode;
    }

    public String getPalletCode() {
        return palletCode;
    }

    public void setPalletCode(String palletCode) {
        this.palletCode = palletCode;
    }
}
