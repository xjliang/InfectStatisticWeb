package edu.fzu.infect.config.accesslog;

import java.util.Date;
import lombok.Data;

@Data
public class AccessLog {

    /**
     * 访问者用户名
     */
    private String username;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求消耗时长
     */
    private Integer duration;

    /**
     * HTTP 方法：GET、POST 等
     */
    private String httpMethod;

    /**
     * HTTP 请求响应状态码
     */
    private Integer httpStatus;

    /**
     * 访问者ip
     */
    private String ip;

    /**
     * 此条记录的创建时间
     */
    private Date createTime;
}
