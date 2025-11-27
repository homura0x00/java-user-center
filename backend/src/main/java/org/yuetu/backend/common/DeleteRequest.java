package org.yuetu.backend.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用的删除请求类
 */
@Data
public class DeleteRequest implements Serializable {

    private Long id;

    @Serial
    private static final long serialVersionUID = -4631779060923890111L;
}
