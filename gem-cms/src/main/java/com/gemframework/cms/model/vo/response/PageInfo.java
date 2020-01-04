package com.gemframework.cms.model.vo.response;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo<T> {
    List<T> rows;
    Long total;
}
