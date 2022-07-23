package com.xy.splitactivity.model;

public class FullPalletDTO{

    /**
     * 拆分任务号
     */
    private String taskCode;

    private String receiveCode;

    /**
     * 合单号
     */
    public FullPalletDTO(){
    }

    public FullPalletDTO(String taskCode, String receiveCode) {
        this.taskCode = taskCode;
        this.receiveCode = receiveCode;
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
}
