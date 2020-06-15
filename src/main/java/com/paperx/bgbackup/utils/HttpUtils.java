package com.paperx.bgbackup.utils;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
public class HttpUtils {

    public HttpUtils() {
        // TODO Auto-generated constructor stub
    }
    /**
     * ModelMap对象响应给前端
     * @param response
     * @param参数为SpringMvc的ModelMap
     * @throws IOException
     */
    public static void responseArraySuccess(HttpServletResponse response,Object obj) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        JSONObject jsonObj = null;
        if(obj != null){
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor());
            jsonObj = JSONObject.fromObject(obj, jsonConfig);
/*		    jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
		    jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");*/
        }
        response.getWriter().write(jsonObj.toString());
    }

    /**
     * ModelMap对象响应给前端  JsonArray形式
     * @param response
     * @param参数为SpringMvc的ModelMap
     * @throws IOException
     */
    public static void responseArraySuccess1(HttpServletResponse response,Object obj) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        JSONArray jsonArrayObj = null;
        if(obj != null){
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor());
            jsonArrayObj =JSONArray.fromObject(obj, jsonConfig);
        }
        response.getWriter().write(jsonArrayObj.toString());
    }

    /**
     * map对象响应给前端
     * @param response
     * @param map
     * @throws IOException
     */
    public static void responseMapSuccess(HttpServletResponse response,Map<String, Object> map) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor());
        response.getWriter().write(JSONObject.fromObject(map,jsonConfig).toString());
    }

    /**
     * pojo类响应给前端
     * @param response
     * @param obj 此为pojo类
     * @throws IOException
     */
    public static void responseObejctSuccess(HttpServletResponse response,Object obj) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.fromObject(obj).toString());
    }

}
