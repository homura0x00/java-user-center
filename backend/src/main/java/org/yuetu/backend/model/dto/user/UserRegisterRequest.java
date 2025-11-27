package org.yuetu.backend.model.dto.user;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册请求
 */
@Data
public class UserRegisterRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -6897795413884975911L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
