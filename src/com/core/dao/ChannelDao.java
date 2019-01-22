package com.core.dao;

import com.core.entity.Channel;

import java.util.List;
import java.util.Map;

public interface ChannelDao {
    public List<Channel> findChannel(Map<String,Object> map);

    public int updataChannel(Channel channel);

    public int addChannel(Channel channel);

    public int deleteChannel(Integer id);

    public int totalChannel();

}
