package org.yuetu.backend.model.dto.user;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserAddRequest implements Serializable {

    /**
     * 用户账户
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色
     */
    private String userRole;

    /**
     * 用户联系邮箱
     */
    private String email;

    @Serial
    private static final long serialVersionUID = -6056671232801899538L;
}
