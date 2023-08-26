package com.tcloud.feign.api.domain.vo;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class UserInfoVO {

    /**
     * 主键
     */
    private Long id;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别：-1未知，0女，1男
     */
    private Integer gender;
    /**
     * 登录ip地址
     */
    private String loginIp;
    /**
     * 个人介绍
     */
    private String personalProfile;
}
