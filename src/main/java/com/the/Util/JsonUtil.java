package com.the.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;

public class JsonUtil {
    public static String getJson(boolean result){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result?"success":"error");
        return jsonObject.toJSONString();
    }
    public static String getJson(boolean result, List<HashMap<String,String>> data){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result?"success":"error");
        JSONArray jsonData= JSONArray.parseArray(JSON.toJSONString(data));
        jsonObject.put("data",jsonData);
        return jsonObject.toJSONString();
    }
    public static String getJson(boolean result, HashMap<String,String> data){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result?"success":"error");
        JSONObject jsonData= JSONArray.parseObject(JSON.toJSONString(data));
        jsonObject.put("data",jsonData);
        return jsonObject.toJSONString();
    }
}
/*
{
    "q":"",
    "p":false,
    "bs":"",
    "csor":"0",
    "err_no":0,
    "errmsg":"",
    "g":[
        {"type":"his_normal",
        "sa":"h_1","q":"list 转jsonarray"},
        {"type":"his_normal","sa":"h_2","q":"hashmap 转jsonarray"},
        {"type":"his_normal","sa":"h_3","q":"hashmap 转fastjson"},
        {"type":"his_normal","sa":"h_4","q":"mysql 表更名"},
        {"type":"his_normal","sa":"h_5","q":"mybatis 事务"},
        {"type":"his_normal","sa":"h_6","q":"mysql 复合主键 查询"},
        {"type":"his_normal","sa":"h_7","q":"mysql 联合主键"},
        {"type":"his_normal","sa":"h_8","q":"mysql 事务"},
        {"type":"his_normal","sa":"h_9","q":"重复登录 mysql"},
        {"type":"his_normal","sa":"h_10","q":"验证员工重复登录 mysql"}
    ],
    "queryid":"0xf2806e7f96d629"
}
 */