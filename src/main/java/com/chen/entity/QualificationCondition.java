package com.chen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.entity
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/24 14:57
 * @Version: 1.0
 */
public class QualificationCondition {
    private String type;
    private String check;
    private String firstDate;
    private String lastDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}
