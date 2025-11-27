package org.yuetu.backend.model.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class LoginUserVO implements Serializable {

    private long id;

    private String userAccount;

    private String userName;

    private String userAvatar;

    private String userProfile;

    private String email;

    private String userRole;

    private Date CreateTime;

    @Serial
    private static final long serialVersionUID = -5224200865817221333L;
}
