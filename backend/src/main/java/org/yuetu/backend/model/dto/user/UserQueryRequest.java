package org.yuetu.backend.model.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yuetu.backend.common.PageRequest;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private long id;

    /**
     * 用户账户
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin
     */
    private String userRole;

    @Serial
    private static final long serialVersionUID = -2318185379692960493L;
}
