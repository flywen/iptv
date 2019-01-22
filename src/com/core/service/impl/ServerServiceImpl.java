package com.core.service.impl;

import com.core.dao.ServerDao;
import com.core.entity.Server;
import com.core.service.ServerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("serverService")
public class ServerServiceImpl implements ServerService {

    @Resource
    private ServerDao serverDao;

    @Override
    public List<Server> findServer(Map<String, Object> map){
        return serverDao.findServer(map);
    }

    @Override
    public int addServer(Server server){
        return serverDao.addServer(server);
    }

    @Override
    public int deleteServer(Integer id){
        return serverDao.deleteServer(id);
    }

    @Override
    public int updataServer(Server server){
        return serverDao.updataServer(server);
    }

}
