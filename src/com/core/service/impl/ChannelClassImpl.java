package com.core.service.impl;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.core.dao.ChannelClassDao;
import com.core.entity.ChannelClass;
import com.core.service.ChannelClassService;

@Service("channelClassService")
public class ChannelClassImpl implements ChannelClassService{

    @Resource
    private ChannelClassDao channelClassDao;

    @Override
    public List<ChannelClass> findChannelClass(Map<String, Object> map){
        return channelClassDao.findChannelClass(map);
    }

    @Override
    public int addChannelClass(ChannelClass channelClass){
        return channelClassDao.addChannelClass(channelClass);
    }

    @Override
    public int deleteChannelClass(Integer id){
        return channelClassDao.deleteChannelClass(id);
    }

    @Override
    public int updataChannelClass(ChannelClass channelClass){
        return channelClassDao.updataChannelClass(channelClass);
    }
}
