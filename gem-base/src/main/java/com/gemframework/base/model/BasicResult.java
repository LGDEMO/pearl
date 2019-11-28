package com.gemframework.base.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

/**
 * @Title: BasicResult.java
 * @Package: com.gemframework.gembasic.model
 * @Date: 2019/11/24 13:49
 * @Version: v1.0
 * @Description: 统一返回格式

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
public class BasicResult {

    // 定义jackson对象
    private static final ObjectMapper mapper = new ObjectMapper();

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public BasicResult() {

    }

    public BasicResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BasicResult(Object data) {
        this.code = 0;
        this.msg = "OK";
        this.data = data;
    }

    /**
     * @Title:  build
     * @MethodName:  build
     * @Param: [status, msg, data]
     * @Retrun: com.gemframework.gembasic.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:39
     */
    public static BasicResult build(Integer status, String msg, Object data) {
        return new BasicResult(status, msg, data);
    }

    /**
     * @Title:  ERROR
     * @MethodName:  ERROR
     * @Param: [code, msg]
     * @Retrun: com.gemframework.gembasic.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:40
     */
    public static BasicResult ERROR(Integer code, String msg) {
        return new BasicResult(code, msg, null);
    }

    /**
     * @Title:  SUCCESS
     * @MethodName:  SUCCESS
     * @Param: [data]
     * @Retrun: com.gemframework.gembasic.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:40
     */
    public static BasicResult SUCCESS(Object data) {
        return new BasicResult(data);
    }

    /**
     * @Title:  SUCCESS
     * @MethodName:  SUCCESS
     * @Param: []
     * @Retrun: com.gemframework.gembasic.model.BasicResult
     * @Description:
     * @Date: 2019/11/27 22:41
     */
    public static BasicResult SUCCESS() {
        return SUCCESS(null);
    }

    /**
     * @param json
     * @return
     * @Description: 没有object对象的转化
     * @author leechenxiang
     * @date 2016年4月22日 下午8:35:21
     */
    public static BasicResult format(String json) {
        try {
            return mapper.readValue(json, BasicResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Title:
     * @MethodName:  formatToClazz
     * @Param: [jsonString, clazz]
     * @Retrun: com.gemframework.gembasic.model.BasicResult
     * @Description: 将json转化为对象
     * @Date: 2019/11/25 13:44
     */
    public static BasicResult formatToClazz(String jsonString, Class<?> clazz) {

        try {
            if (clazz == null) {
                return mapper.readValue(jsonString, BasicResult.class);
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
     * @Retrun: com.gemframework.gembasic.model.BasicResult
     * @Description: 将json转化为list clazz为list对象
     * @Date: 2019/11/25 13:45
     */
    public static BasicResult formatToList(String jsonString, Class<?> clazz) {

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
