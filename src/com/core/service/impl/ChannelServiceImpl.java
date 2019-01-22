package com.core.service.impl;

import com.core.dao.ChannelDao;
import com.core.entity.Channel;
import com.core.service.ChannelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

    @Resource
    private ChannelDao channelDao;

    @Override
    public List<Channel> findChannel(Map<String,Object> map){
        return channelDao.findChannel(map);
    }

    @Override
    public int addChannel(Channel channel){
        return channelDao.addChannel(channel);
    }

    @Override
    public int deleteChannel(Integer id){
        return channelDao.deleteChannel(id);
    }

    @Override
    public int updataChannel(Channel channel){
        return channelDao.updataChannel(channel);
    }

    @Override
    public int totalChannel(){ return channelDao.totalChannel();}
}
