package com.core.admin;

import com.core.entity.Channel;
import com.core.service.ChannelService;
import com.core.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Resource
    private ChannelService channelService;


    //查询频道列表，page、rows是easyUI传来的当前页码和每页显示条数，给select语句加limit条件
    @RequestMapping("/list")
    public String list(
            @RequestParam(value = "page",required = false) Integer page,
            @RequestParam(value = "rows",required = false) Integer rows,
            Channel channel, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page!=null && rows!=null){
            Integer start = (page-1)*rows;
            map.put("start",start);
            map.put("size",rows);
        }
        List<Channel> channelList = channelService.findChannel(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(channelList);
        result.put("rows", jsonArray);
        Integer total = channelService.totalChannel();
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/save")
    public String save(Channel channel,HttpServletResponse response) throws Exception {
        int resultTotal = 0;
        if (channel.getId() == null) {
            resultTotal = channelService.addChannel(channel);
        } else {
            resultTotal = channelService.updataChannel(channel);
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception{
        String[] idsStr = ids.split(",");
        for (int i =0; i < idsStr.length; i++){
            channelService.deleteChannel(Integer.parseInt(idsStr[i]));
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response,result);
        return null;
    }

    //提供JSONArray节目清单接口给播发程序调用
    @RequestMapping("/listall")
    public String listall(HttpServletResponse response) throws Exception {
        List<Channel> channelList = channelService.findChannel(null);
        JSONArray json = JSONArray.fromObject(channelList);
        ResponseUtil.write(response, json);
        return null;
    }

}
