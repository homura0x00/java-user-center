package org.yuetu.backend.common;

import org.yuetu.backend.exception.ErrorCode;

public class ResultUtils {

    /**
     * 成功
     *
     * @param data 数据
     * @param <T> 数据类型
     * @return 响应
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @return 响应
     */
    public static BaseResponse<?> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败
     *
     * @param code 自定义错误码
     * @param message 自定义错误消息
     * @return 响应
     */
    public static BaseResponse<?> error(int code, String message) {
        return new BaseResponse<>(code, message);
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @param message 自定义错误消息
     * @return 响应
     */
    public static BaseResponse<?> error(ErrorCode errorCode, String message) {
        return new BaseResponse<>(errorCode.getCode(), null, message);
    }
}
