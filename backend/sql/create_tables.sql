CREATE DATABASE IF NOT EXISTS `yuetu_web`;

USE `yuetu_web`;

CREATE TABLE IF NOT EXISTS `user`
(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `userAccount` VARCHAR(256) NOT NULL COMMENT '账户',
    `userPassword` VARCHAR(512) NOT NULL COMMENT '密码',
    `userName` VARCHAR(256) NULL COMMENT '昵称',
    `userAvatar` VARCHAR(1024) NULL COMMENT '用户头像',
    `userProfile` VARCHAR(512) NULL COMMENT '用户简介',
    `userRole` VARCHAR(256) DEFAULT 'user' NOT NULL COMMENT '角色: user / admin',
    `email` VARCHAR(512) NULL COMMENT '邮箱',
    `createTime` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `updateTime` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新时间',
    `isDelete` TINYINT DEFAULT 0 NOT NULL COMMENT '逻辑删除：0-存在，1-已删除',
    INDEX idx_userAccount(`userAccount`)
) COMMENT '用户表' COLLATE = utf8mb4_unicode_ci;
