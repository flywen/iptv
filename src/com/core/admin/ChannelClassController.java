package com.core.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.core.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.core.entity.ChannelClass;
import com.core.service.ChannelClassService;

@Controller
@RequestMapping("/channelclass")
public class ChannelClassController {

    @Resource
    private ChannelClassService channelClassService;

    @RequestMapping("/list")
    public String list(ChannelClass channelClass, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("className", StringUtil.formatLike(channelClass.getClassName()));
        map.put("className","jjj" );
        List<ChannelClass> channelClassesList = channelClassService.findChannelClass(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(channelClassesList);
        result.put("rows", jsonArray);
        result.put("total", 3);

        ResponseUtil.write(response, result);


        return null;
    }


    @RequestMapping("/listtosel")
    public String listtosel(ChannelClass channelClass, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("className", StringUtil.formatLike(channelClass.getClassName()));
//        map.put("className","jjj" );
        List<ChannelClass> channelClassesList = channelClassService.findChannelClass(map);
//        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(channelClassesList);
//        result.put("rows", jsonArray);
//        result.put("total", 3);

        ResponseUtil.write(response, jsonArray);


        return null;
    }

    @RequestMapping("/save")
    public String save(ChannelClass channelClass,HttpServletResponse response) throws Exception {
        int resultTotal = 0;
        if (channelClass.getId() == null){
            resultTotal = channelClassService.addChannelClass(channelClass);
        } else {
            resultTotal = channelClassService.updataChannelClass(channelClass);
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception{
        System.out.print("into delete");
        String[] idsStr = ids.split(",");
        for (int i =0; i < idsStr.length; i++){
            channelClassService.deleteChannelClass(Integer.parseInt(idsStr[i]));
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response,result);
        System.out.print("endof delete");
        return null;
    }



}

