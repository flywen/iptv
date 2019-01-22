package com.core.entity;

public class Server {
    @Override
    public String toString(){
        return "Server [id=" + id + ", name=" + name + ", ipAddress =" + ipAddress +"]";
    }

    private String id;
    private String name;
    private String ipAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
