package com.core.dao;

import com.core.entity.Server;

import java.util.List;
import java.util.Map;

public interface ServerDao {
    public List<Server> findServer(Map<String, Object> map);

    public int updataServer(Server server);

    public int addServer(Server server);

    public int deleteServer(Integer id);
}
