import request from "../request.ts";

/** userRegister POST /api/user/register */
export async function userRegister(
    body: API.UserRegisterRequest
) {
    return request<API.BaseResponseLong>("/api/user/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        data: body,
    });
}

/** loginUser POST /api/user/login */
export async function userLogin(
    body: API.UserLoginRequest
) {
    return request<API.BaseResponseUserLoginVO>('/api/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        data: body,
    });
}

/** getLoginUser GET /api/user/get/login */
export async function getLoginUserUsingGet() {
    return request<API.BaseResponseUserLoginVO>('/api/user/get/login', {
        method: 'GET',
    })
}