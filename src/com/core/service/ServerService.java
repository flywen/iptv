package com.core.service;

import com.core.entity.Server;

import java.util.List;
import java.util.Map;

public interface ServerService {

    public List<Server> findServer(Map<String, Object> map);
    public int addServer(Server server);
    public int deleteServer(Integer id);
    public int updataServer(Server server);

}
