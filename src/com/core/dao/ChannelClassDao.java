package com.core.dao;

import java.util.List;
import java.util.Map;

import com.core.entity.ChannelClass;

public interface ChannelClassDao {
    public List<ChannelClass> findChannelClass(Map<String, Object> map);

    public int updataChannelClass(ChannelClass channelClass);

    public int addChannelClass(ChannelClass channelClass);

    public int deleteChannelClass(Integer id);
}
