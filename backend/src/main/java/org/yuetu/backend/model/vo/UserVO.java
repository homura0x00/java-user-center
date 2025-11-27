package org.yuetu.backend.model.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 9214272097466859074L;

    private long id;

    private String userAccount;

    private String userName;

    private String userAvatar;

    private String userProfile;

    private String userRole;

    private String email;

    private Date createTime;
}
