/**
 * FileName: GsonView.java
 * Author:   wormchaos
 * Date:     2014-8-7 下午7:25:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.AbstractView;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A View that renders its model as a JSON object.
 *
 * @author Johnny
 */
public class GsonView extends AbstractView {
    private String datePattern = "yyyy-MM-dd HH:mm:ss";
    /** Default content type. Overridable as bean property. */
    //private static final String DEFAULT_JSON_CONTENT_TYPE = "application/json";
    private String jsonObjectName;
    
    
    public GsonView() {
        super();
    }
    public GsonView(String jsonObjectName, ExclusionStrategy excludeStrategy) {
        super();
        this.jsonObjectName = jsonObjectName;
        this.excludeStrategy = excludeStrategy;
    }
    private int responseStatus = HttpStatus.OK.value();
    private ExclusionStrategy excludeStrategy;
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setStatus(getResponseStatus());
        response.setContentType(getContentType());
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat(datePattern);
        if (excludeStrategy != null) {
            gsonBuilder.setExclusionStrategies(excludeStrategy);
        }
        Gson gson = gsonBuilder.create();
        gson.toJson(jsonObjectName == null ? model : model.get(jsonObjectName), response.getWriter());
    }
    /**
     * @return the objectName in model
     */
    public String getJsonObjectName() {
        return jsonObjectName;
    }
    
    public void setDatePattern(String pattern){
        this.datePattern = pattern;
    }
    /**
     * @param objectName the objectName in model that will be convert to json, if not set, then convert the hole model to json
     */
    public void setJsonObjectName(String objectName) {
        this.jsonObjectName = objectName;
    }
    /**
     * @return the excludeStrategy
     */
    public ExclusionStrategy getExcludeStrategy() {
        return excludeStrategy;
    }
    /**
     * @param excludeStrategy the excludeStrategy to set
     */
    public void setExcludeStrategy(ExclusionStrategy excludeStrategy) {
        this.excludeStrategy = excludeStrategy;
    }
    /* (non-Javadoc)
     * @see org.springframework.web.servlet.view.AbstractView#getContentType()
     */
    @Override
    public String getContentType() {
        return "text/html;charset=utf-8";
    }
    /**
     * @return the responseStatus
     */
    public int getResponseStatus() {
        return responseStatus;
    }
    /**
     * @param responseStatus the responseStatus to set
     */
    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }


}
