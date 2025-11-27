declare namespace API {
    type UserRegisterRequest = {
        userAccount?: string;
        userPassword?: string;
        checkPassword?: string;
    }

    type BaseResponseLong = {
        id?: number;
    }

    type UserLoginRequest = {
        userAccount?: string;
        userPassword?: string;
    }

    type BaseResponseUserLoginVO = {
        code?: number;
        data?: LoginUserVO;
        message?: string;
    }

    type LoginUserVO = {
        id?: number
        updateTime?: string
        userAccount?: string
        userAvatar?: string
        userName?: string
        userProfile?: string
        userRole?: string
        createTime?: string
        editTime?: string
    }

    type UserVO = {
        id?: number
        updateTime?: string
        userAccount?: string
        userAvatar?: string
        userName?: string
        userProfile?: string
        userRole?: string
        createTime?: string
        editTime?: string
    }
}