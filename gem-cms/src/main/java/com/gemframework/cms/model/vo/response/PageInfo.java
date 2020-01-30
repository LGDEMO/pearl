package com.gemframework.cms.model.vo.response;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo<T> {
    Long total;
    List<T> rows;
}
