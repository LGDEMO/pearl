package com.gemframework.bas.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemframework.bas.common.enums.ResultCode;
import lombok.Data;

import java.util.List;

/**
 * @Title: BasicResult.java
 * @Package: com.gemframework.bas.model
 * @Date: 2019/11/24 13:49
 * @Version: v1.0
 * @Description: 统一返回格式

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
public class BaseResult {

    // 定义jackson对象
    private static final ObjectMapper mapper = new ObjectMapper();

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public BaseResult() {

    }

    public BaseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(Object data) {
        this.code = 0;
        this.msg = "OK";
        this.data = data;
    }

    public BaseResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = null;
    }

    /**
     * @Title:  build
     * @MethodName:  build
     * @Param: [status, msg, data]
     * @Retrun: com.gemframework.bas.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:39
     */
    public static BaseResult build(Integer status, String msg, Object data) {
        return new BaseResult(status, msg, data);
    }

    /**
     * @Title:  ERROR
     * @MethodName:  ERROR
     * @Param: [code, msg]
     * @Retrun: com.gemframework.bas.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:40
     */
    public static BaseResult ERROR(Integer code, String msg) {
        return new BaseResult(code, msg, null);
    }

    /**
     * @Title:  ERROR
     * @MethodName:  ERROR
     * @Param: [resultCode]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 14:37
     */
    public static BaseResult ERROR(ResultCode resultCode) {

        return new BaseResult(resultCode.getCode(), resultCode.getMsg(), null);
    }

    /**
     * @Title:  SUCCESS
     * @MethodName:  SUCCESS
     * @Param: [data]
     * @Retrun: com.gemframework.bas.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:40
     */
    public static BaseResult SUCCESS(Object data) {
        return new BaseResult(data);
    }

    /**
     * @Title:  SUCCESS
     * @MethodName:  SUCCESS
     * @Param: []
     * @Retrun: com.gemframework.bas.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:41
     */
    public static BaseResult SUCCESS() {
        return SUCCESS(null);
    }

    /**
     * @param json
     * @return
     * @Description: 没有object对象的转化
     * @author leechenxiang
     * @date 2016年4月22日 下午8:35:21
     */
    public static BaseResult format(String json) {
        try {
            return mapper.readValue(json, BaseResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Title:
     * @MethodName:  formatToClazz
     * @Param: [jsonString, clazz]
     * @Retrun: com.gemframework.bas.model.BasicResult
     * @Description: 将json转化为对象
     * @Date: 2019/11/25 13:44
     */
    public static BaseResult formatToClazz(String jsonString, Class<?> clazz) {

        try {
            if (clazz == null) {
                return mapper.readValue(jsonString, BaseResult.class);
            }
            JsonNode jsonNode = mapper.readTree(jsonString);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = mapper.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = mapper.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @Title:
     * @MethodName:  formatToList
     * @Param: [jsonString, clazz]
     * @Retrun: com.gemframework.bas.model.BasicResult
     * @Description: 将json转化为list clazz为list对象
     * @Date: 2019/11/25 13:45
     */
    public static BaseResult formatToList(String jsonString, Class<?> clazz) {

        try {
            JsonNode jsonNode = mapper.readTree(jsonString);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = mapper.readValue(data.traverse(),
                        mapper.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
