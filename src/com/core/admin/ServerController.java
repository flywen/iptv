package com.core.admin;

import com.core.entity.Server;
import com.core.service.ServerService;
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
@RequestMapping("/server")
public class ServerController {

    @Resource
    private ServerService serverService;

    @RequestMapping("/list")
    public String list(Server server, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","jjj" );
        List<Server> serverList = serverService.findServer(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(serverList);
        result.put("rows", jsonArray);
        result.put("total", 3);

        ResponseUtil.write(response, result);

        return null;
    }

    @RequestMapping("/save")
    public String save(Server server,HttpServletResponse response) throws Exception {
        int resultTotal = 0;
        if (server.getId() == null){
            resultTotal = serverService.addServer(server);
        } else {
            resultTotal = serverService.updataServer(server);
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
            serverService.deleteServer(Integer.parseInt(idsStr[i]));
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response,result);
        return null;
    }

}
