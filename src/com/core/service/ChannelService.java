package com.core.service;

import com.core.entity.Channel;

import java.util.List;
import java.util.Map;

public interface ChannelService {
    public List<Channel> findChannel(Map<String,Object> map);
    public int addChannel(Channel channel);
    public int deleteChannel(Integer id);
    public int updataChannel(Channel channel);
    public int totalChannel();
}
