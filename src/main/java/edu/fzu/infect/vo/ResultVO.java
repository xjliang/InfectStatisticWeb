package edu.fzu.infect.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * @author xjliang
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -8895436491709517963L;

    /** 状态码 0 表示成功 */
    private Integer code;

    /** 状态码说明 */
    private String msg;

    /** 返回数据*/
    private T data;
}
