package org.yuetu.backend.model.dto.user;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7988792616801332421L;
    /**
     * 登陆账号
     */
    private String userAccount;
    /**
     * 登陆密码
     */
    private String userPassword;
}
