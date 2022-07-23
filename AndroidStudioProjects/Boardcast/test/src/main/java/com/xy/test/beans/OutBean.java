package com.xy.test.beans;

import java.util.List;

public class OutBean {

    private String name;
    private int Count;
    private List<InsideBean> mInsideBeans;
    public static class InsideBean{
        private String trayCode;
        public InsideBean(){}{

        }
        public InsideBean(String code){
            this.trayCode = code;
        }

        public void setTrayCode(String trayCode) {
            this.trayCode = trayCode;
        }

        public String getTrayCode() {
            return trayCode;
        }
    }

    public OutBean() {
    }

    public OutBean(String name, int count) {
        this.name = name;
        Count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return Count;
    }

    public OutBean(String name, int count, List<OutBean.InsideBean> mInsideBeans) {
        this.name = name;
        Count = count;
        this.mInsideBeans = mInsideBeans;
    }

    public void setmInsideBeans(List<InsideBean> mInsideBeans) {
        this.mInsideBeans = mInsideBeans;
    }

    public List<InsideBean> getmInsideBeans() {
        return mInsideBeans;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        Count = count;
    }
}
