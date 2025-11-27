package org.yuetu.backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.yuetu.backend.model.dto.user.UserQueryRequest;
import org.yuetu.backend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.yuetu.backend.model.vo.LoginUserVO;
import org.yuetu.backend.model.vo.UserVO;

import java.util.List;

/**
* @author homura
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-11-09 18:54:03
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户ID
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 获取加密后的密码
     *
     * @param userPassword 用户密码（原始）
     * @return  加密密码
     */
    String generatePwd(String userPassword);

    /**
     * 用户登陆
     *
     * @param userAccount   登陆账号
     * @param userPassword 登陆密码
     * @param request   请求上下文
     * @return 登陆信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前用户登陆信息
     *
     * @param request   请求上下文
     * @return          用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取脱敏类的登陆用户信息
     *
     * @param user 用户
     * @return 脱敏后的用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取脱敏类的用户信息
     *
     * @param user 用户信息
     * @return 脱敏后的用户信息
     */
    UserVO getUserVO(User user);

    /**
     * 用户注销
     *
     * @param request 上下文
     * @return 退出if
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 查询条件
     *
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 获取脱敏后的用户列表
     *
     * @param userList 用户列表（未脱敏）
     * @return
     */
    List<UserVO> getUserVOList(List<User> userList);

}
