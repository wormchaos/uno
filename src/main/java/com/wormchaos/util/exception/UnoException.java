/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: UnoException.java
 * Author:   13071604
 * Date:     2014-8-5 下午4:42:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util.exception;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 13071604
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UnoException extends Exception{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6994530210973700934L;

    /**
     * 异常编码
     */
    private String errorCode;
    
    /**
     * 构造方法
     * 
     * @param errorCode 错误码
     */
    public UnoException(String errorCode){
        this.errorCode = errorCode;
    }

    public UnoException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
}
