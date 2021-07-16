package com.the.config;

import com.alibaba.fastjson.JSONObject;
import com.the.pojo.Result;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chengtianping
 * @description Spring MVC 异常处理
 * 两种处理机制
 * 1. 直接实现自己的HandlerExceptionResolver，
 * 当然这也包括使用Spring已经为我们提供好的SimpleMappingExceptionResolver和DefaultHandlerExceptionResolver
 * 2. 使用注解的方式实现一个专门用于处理异常的Controller——ExceptionHandler
 * @date 2018/5/21
 */
public class SpringGlobalExceptionHandler extends SimpleMappingExceptionResolver {

    private static Logger log = Logger.getLogger(SpringGlobalExceptionHandler.class);

    public static final String UTF_8 = "utf-8";
    public static final String ACCEPT = "accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String X_REQUESTED_WITH = "X-Requested-With";
    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @Override
    public ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                           Object o, Exception ex) {
        ModelAndView modelAndView;
        httpServletResponse.setCharacterEncoding(UTF_8);
        String viewName = determineViewName(ex,httpServletRequest);
        String accept = httpServletRequest.getHeader(ACCEPT);
        boolean isJsonXMLRequest = accept != null && !(accept.contains(APPLICATION_JSON)
                || (httpServletRequest.getHeader(X_REQUESTED_WITH) != null
                && httpServletRequest.getHeader(X_REQUESTED_WITH).contains(XML_HTTP_REQUEST)));
        if (!isJsonXMLRequest) {
            //非 json xml ajax 请求 返回正常的视图
            Integer statusCode = determineStatusCode(httpServletRequest, viewName);
            if (statusCode != null) {
                applyStatusCodeIfPossible(httpServletRequest, httpServletResponse, statusCode);
            }
            modelAndView = getModelAndView(viewName, ex, httpServletRequest);
        } else {
            PrintWriter writer = null;
            try {
                //json xml 请求 ajax请求 返回json格式的错误信息
                // json 请求返回
                httpServletResponse.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
                writer = httpServletResponse.getWriter();
                Result<String> result = Result.error(ex);
                writer.write(JSONObject.toJSONString(result));
                writer.flush();
            } catch (IOException e) {
                if (log.isInfoEnabled()) {
                    logger.error("SpringGlobalExceptionHandler exception  ",e);
                }
            }finally{
                if(null != writer){
                    writer.flush();
                    writer.close();
                }
            }
            return null;
        }
        return modelAndView;
    }
}
