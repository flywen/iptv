package com.core.entity;

public class Channel {

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", in_url='" + in_url + '\'' +
                ", format='" + format + '\'' +
                ", codec='" + codec + '\'' +
                ", out_url='" + out_url + '\'' +
                ", status=" + status +
                ", ismulticast=" + ismulticast +
                ", class_id=" + class_id +
//                ", server=" + server +
                '}';
    }

    private Integer id;
    private String name;
    private String in_url;
    private String format;
    private String codec;
    private String out_url;
    private Integer status;
    private Integer ismulticast;
    private Integer class_id;
    private String className;
//    private Server server;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIn_url() {
        return in_url;
    }

    public void setIn_url(String in_url) {
        this.in_url = in_url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getOut_url() {
        return out_url;
    }

    public void setOut_url(String out_url) {
        this.out_url = out_url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsmulticast() {
        return ismulticast;
    }

    public void setIsmulticast(Integer ismulticast) {
        this.ismulticast = ismulticast;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
//    public Server getServer() {
//        return server;
//    }
//
//    public void setServer(Server server) {
//        this.server = server;
//    }
}
