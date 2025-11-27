package org.yuetu.backend.common;

import lombok.Data;

/**
 * 通用的分页请求类
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private int current = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 排列字段
     */
    private String sortField;

    /**
     * 排列顺序（默认升序）
     */
    private String sortOrder = "descend";
}
