package com.core.entity;

import java.util.List;

public class ChannelClass {

    @Override
    public String toString(){
        return "ChannelClass [id=" + id + ", className=" + className + ", desc=" + desc +"]";
    }

    private String id;
    private String className;
    private String desc;
    private List<Channel> channels;

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
