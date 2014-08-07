/*
 * FileName: UnoException.java
 * Author:   wormchaos
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
 * @author wormchaos
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
     * 
     * 功能描述: <br>
     * 检查是否是Json错误
     *
     * @param errorCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static boolean isJsonException(String errorCode){
        if (errorCode.startsWith("J")) {
            return true;
        }
        return false;
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
