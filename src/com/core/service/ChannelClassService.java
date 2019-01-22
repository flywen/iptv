package com.core.service;

import java.util.List;
import java.util.Map;

import com.core.entity.ChannelClass;
import org.springframework.stereotype.Service;

public interface ChannelClassService {

    public List<ChannelClass> findChannelClass(Map<String, Object> map);
    public int addChannelClass(ChannelClass channelClass);
    public int deleteChannelClass(Integer id);
    public int updataChannelClass(ChannelClass channelClass);
}
