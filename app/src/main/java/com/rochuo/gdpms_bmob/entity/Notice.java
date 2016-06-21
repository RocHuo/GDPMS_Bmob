package com.rochuo.gdpms_bmob.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by 小蛋花 on 2016/6/19.
 */
public class Notice extends BmobObject {
    private String title;
    private String content;
    private String author;
    private BmobDate time;

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }

    public BmobDate getTime() {
        return time;
    }

    public void setTime(BmobDate time) {
        this.time = time;
    }
}
